package com.epam.labs.lab7;

import com.epam.labs.lab7.repository.CountryRepository;
import com.epam.labs.lab7.repository.CountryJpaRepository;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@FieldDefaults(level = AccessLevel.PRIVATE)
@PropertySource("classpath:db.properties")
public class ApplicationConfig {
    @Value("${driverClassName}")
    String driverClassName;
    @Value("${url}")
    String url;
    @Value("${username}")
    String username;
    @Value("${password}")
    String password;
    @Value("classpath:schema.sql")
    Resource schemaScript;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    @SneakyThrows
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        @SuppressWarnings("unchecked")
        Class<? extends java.sql.Driver> driverClass =
                (Class<? extends java.sql.Driver>) Class.forName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Bean
    public CountryRepository countryRepository() {
        return new CountryJpaRepository();
    }
}
