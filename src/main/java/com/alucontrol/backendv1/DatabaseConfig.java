package com.alucontrol.backendv1;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up the database connection using HikariCP.
 * This class is responsible for creating and configuring the DataSource bean
 * that will be used by the application to connect to the database.
 */
import javax.sql.DataSource;
//https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
@Configuration
public class DatabaseConfig
{
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Bean
    public DataSource dataSource() {

        //Create a new HikariConfig instance
        HikariConfig config = new HikariConfig();

        //Set the JDBC URL from the injected property
        config.setJdbcUrl(dbUrl);

        //Create and return a HikariDataSource with the configured settings
        return new HikariDataSource(config);
    }
}
