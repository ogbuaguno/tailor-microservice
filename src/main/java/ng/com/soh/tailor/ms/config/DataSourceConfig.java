package ng.com.soh.tailor.ms.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Blurryface on 10/25/17.
 */

@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriverClassName;
    @Value("${spring.datasource.data-username}")
    private String dataSourceUsername;
    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Bean
    public DataSource dataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(dataSourceUrl);
        hikariDataSource.setDriverClassName(dataSourceDriverClassName);
        hikariDataSource.setUsername(dataSourceUsername);
        hikariDataSource.setPassword(dataSourcePassword);

        return hikariDataSource;
        /*DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(dataSourceDriverClassName);
        dataSourceBuilder.url(dataSourceUrl);
        dataSourceBuilder.username(dataSourceUsername);
        dataSourceBuilder.password(dataSourcePassword);

        return dataSourceBuilder.build();*/
    }

}
