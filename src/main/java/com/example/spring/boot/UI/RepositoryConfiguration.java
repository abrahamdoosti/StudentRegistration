package com.example.spring.boot.UI;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.example.spring.boot.model" })
@EnableJpaRepositories(basePackages = { "com.example.spring.boot.StudentDAO" })
@EnableTransactionManagement
public class RepositoryConfiguration {
}