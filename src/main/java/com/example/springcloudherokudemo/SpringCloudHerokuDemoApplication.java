package com.example.springcloudherokudemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.cloud.Cloud;
import org.springframework.context.annotation.Bean;


import javax.sql.DataSource;

@SpringBootApplication
public class SpringCloudHerokuDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHerokuDemoApplication.class, args);
    }

    @Bean
    @Profile("cloud")
    public DataSource dataSource(Cloud cloud) {
        return cloud.getSingletonServiceConnector(DataSource.class, null);
    }

    @Bean
    @Profile("default")
    public DataSource localDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/mydatabase");
        dataSource.setUsername("myuser");
        dataSource.setPassword("mypassword");
        return dataSource;
    }

}
