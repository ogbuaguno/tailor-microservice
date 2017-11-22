package ng.com.soh.tailor.ms.dao;

import ng.com.soh.ms.core.model.Authorities;
import ng.com.soh.ms.core.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by Blurryface on 10/30/17.
 */

@Repository
public class RoleDao extends AbstractDao<Role>{
    private SimpleJdbcCall findRoleByName, getAuthorities;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.create = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_role").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Role.class));
        this.find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_role").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Role.class));
        this.update = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_role").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Role.class));
        this.findRoleByName = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_role_by_name")
                .returningResultSet(SINGLE, new BeanPropertyRowMapper(Role.class));
        this.getAuthorities = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_authorities")
                .returningResultSet(SINGLE, new BeanPropertyRowMapper(Authorities.class));
    }

    public Role findRoleByName(String name){
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("name", name);
        Map<String, Object> map = findRoleByName.execute(parameterSource);
        List<Role> list = map != null && !map.isEmpty() ? (List<Role>) map.get(SINGLE) : null;
        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

    public Authorities getAuthorities(int roleId){
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("role_id", roleId);
        Map<String, Object> map = getAuthorities.execute(parameterSource);
        List<Authorities> list = map != null && !map.isEmpty() ? (List<Authorities>) map.get(SINGLE) : null;
        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

}
