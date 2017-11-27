package com.jatheon.demo.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.jatheon.demo.weather.repository")
public class PersistenceConfig {

    private static final boolean DEVELOPMENT_SHOW_SQL = true;

    private static final String SHOW_SQL_TRUE_STRING_PROPERTY = "true";
    private static final String FORMAT_SQL_TRUE_STRING_PROPERTY = "true";
    private static final String USE_SQL_COMMENTS_TRUE_STRING_PROPERTY = "true";

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:db/sql/schema.sql", "classpath:db/sql/initial-data.sql")
                .build();
    }

    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(DEVELOPMENT_SHOW_SQL);
        return jpaVendorAdapter;
    }

    private Properties getJpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", SHOW_SQL_TRUE_STRING_PROPERTY);
        properties.setProperty("hibernate.format_sql", FORMAT_SQL_TRUE_STRING_PROPERTY);
        properties.setProperty("hibernate.use_sql_comments", USE_SQL_COMMENTS_TRUE_STRING_PROPERTY);
        properties.setProperty("hibernate.id.new_generator_mappings", "false");
        return properties;
    }


    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.jatheon.demo.weather.model");
        emf.setJpaVendorAdapter(jpaVendorAdapter());
        emf.setJpaProperties(getJpaProperties());
        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
