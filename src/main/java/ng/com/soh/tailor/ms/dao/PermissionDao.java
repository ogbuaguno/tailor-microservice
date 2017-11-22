package ng.com.soh.tailor.ms.dao;

import ng.com.soh.ms.core.model.Permission;
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
 * Created by Blurryface on 10/26/17.
 */

@Repository
public class PermissionDao extends AbstractDao<Permission>{
    private SimpleJdbcCall findPermissionByName;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.create = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_permission").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Permission.class));
        this.find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_permission").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Permission.class));
        this.update = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_permission").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Permission.class));
        this.findPermissionByName = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_permission_by_name").
                returningResultSet(SINGLE, new BeanPropertyRowMapper(Permission.class));
    }

    public Permission findPermissionByName(String name){
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("name", name);
        Map<String, Object> map = findPermissionByName.execute(parameterSource);
        List<Permission> list = map != null && !map.isEmpty() ? (List<Permission>) map.get(SINGLE) : null;
        return list != null && !list.isEmpty() ? list.get(0) : null;
    }
}
