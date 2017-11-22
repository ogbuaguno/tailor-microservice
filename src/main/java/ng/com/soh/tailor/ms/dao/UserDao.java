package ng.com.soh.tailor.ms.dao;

import ng.com.soh.ms.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by Blurryface on 10/31/17.
 */

@Repository
public class UserDao extends AbstractDao<User>{

    private SimpleJdbcCall updateUserLogin, retrieveAuthorities;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.create = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_user").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(User.class));
        this.find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_user").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(User.class));
        this.update = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_user").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(User.class));
        updateUserLogin = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_user_login").withReturnValue();
        retrieveAuthorities = new SimpleJdbcCall(jdbcTemplate).withProcedureName("retrieve_authorities").withReturnValue();
    }

    public void updateUserLogin(int id){
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        updateUserLogin.execute(parameterSource);
    }
}
