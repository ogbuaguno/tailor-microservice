package ng.com.soh.tailor.ms.dao;

import ng.com.soh.ms.core.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by Blurryface on 10/30/17.
 */

@Repository
public class AddressDao extends AbstractDao<Address>{

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.create = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_address").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Address.class));
        this.find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_address").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Address.class));
        this.update = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_address").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Address.class));
    }

}
