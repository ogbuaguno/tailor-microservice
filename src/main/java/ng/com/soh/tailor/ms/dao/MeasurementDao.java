package ng.com.soh.tailor.ms.dao;

import ng.com.soh.ms.core.model.Measurement;
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
public class MeasurementDao extends AbstractDao<Measurement>{

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.create = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_measurement").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Measurement.class));
        this.find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_measurement").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Measurement.class));
        this.update = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_measurement").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Measurement.class));
    }
}
