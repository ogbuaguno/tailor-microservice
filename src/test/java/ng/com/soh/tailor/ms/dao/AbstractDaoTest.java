package ng.com.soh.tailor.ms.dao;

import ng.com.soh.tailor.ms.config.DataSourceConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Created by Blurryface on 10/26/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class, PermissionDao.class, RoleDao.class, UserDao.class,
        MeasurementDao.class, CountryDao.class, AddressDao.class},
        loader= SpringBootContextLoader.class)
@TestPropertySource(locations = {"classpath:application.properties"})
public class AbstractDaoTest {

    @Autowired
    private DataSource dataSource;
    protected static JdbcTemplate jdbcTemplate;

    @Before
    public void setUp(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
