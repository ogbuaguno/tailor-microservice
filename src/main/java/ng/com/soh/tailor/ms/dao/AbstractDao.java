package ng.com.soh.tailor.ms.dao;


import ng.com.soh.ms.core.model.BaseModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by Blurryface on 10/25/17.
 */

public abstract class AbstractDao<T extends BaseModel> {
    protected JdbcTemplate jdbcTemplate;
    protected static String SINGLE = "result" , MULTIPLE = "list";
    protected SimpleJdbcCall create, find, findAll, update, delete;

    void setDataSource(DataSource dataSource){
    }

    public <T> T create(T model){
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(model);
        Map<String, Object> sourceMap = create.execute(parameterSource);
        List<T> list = sourceMap != null && !sourceMap.isEmpty() ? (List<T>) sourceMap.get(SINGLE) : null;
        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

    public <T> T find(int id){
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        Map<String, Object> sourceMap = find.execute(parameterSource);
        List<T> list = sourceMap != null && !sourceMap.isEmpty() ? (List<T>) sourceMap.get(SINGLE) : null;
        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

    public <T> T update(T model){
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(model);
        Map<String, Object> sourceMap = update.execute(parameterSource);
        List<T> list = sourceMap != null && !sourceMap.isEmpty() ? (List<T>) sourceMap.get(SINGLE) : null;
        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

    public void delete(int id){
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        delete.execute(parameterSource);
    }
}
