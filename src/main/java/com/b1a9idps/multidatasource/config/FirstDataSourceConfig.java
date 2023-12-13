package com.b1a9idps.multidatasource.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration(proxyBeanMethods = false)
@EnableJpaRepositories(
        basePackages = "com.b1a9idps.multidatasource.repository.first",
        entityManagerFactoryRef = "firstEntityManager",
        transactionManagerRef = "firstTransactionManager"
)
public class FirstDataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.first")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource firstDataSource(DataSourceProperties firstDataSourceProperties) {
        return firstDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean firstEntityManager(
            DataSource firstDataSource, JpaProperties japProperties) {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(japProperties.isShowSql());

        return new EntityManagerFactoryBuilder(hibernateJpaVendorAdapter, japProperties.getProperties(), null)
                .dataSource(firstDataSource)
                .persistenceUnit("firstTransactionManager")
                .packages("com.b1a9idps.multidatasource.entity")
                .build();
    }

    @Bean
    public JpaTransactionManager firstTransactionManager(EntityManagerFactory firstEntityManager) {
        return new JpaTransactionManager(firstEntityManager);
    }
}
