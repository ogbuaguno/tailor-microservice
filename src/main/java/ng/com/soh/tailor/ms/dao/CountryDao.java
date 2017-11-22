package ng.com.soh.tailor.ms.dao;

import ng.com.soh.ms.core.model.Country;
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
public class CountryDao extends AbstractDao<Country> {
    private SimpleJdbcCall findCountryByName;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.create = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_country").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Country.class));
        this.find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_country").returningResultSet(SINGLE,
                new BeanPropertyRowMapper(Country.class));
        findCountryByName = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_country_by_name")
                .returningResultSet(SINGLE, new BeanPropertyRowMapper(Country.class));
    }

    public Country findCountryByName(String name){
        SqlParameterSource parameterSource = new MapSqlParameterSource("name", name);
        Map<String, Object> sourceMap = findCountryByName.execute(parameterSource);
        List<Country> list = sourceMap != null && !sourceMap.isEmpty() ? (List<Country>) sourceMap.get(SINGLE) : null;
        return list != null && !list.isEmpty() ? list.get(0) : null;
    }
}
