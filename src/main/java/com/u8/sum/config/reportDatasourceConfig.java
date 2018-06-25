package com.u8.sum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryReport",
        transactionManagerRef="transactionManagerReport",
        basePackages= { "com.u8.sum.domain.report" }) //设置Repository所在位置
public class reportDatasourceConfig {

    @Autowired
    @Qualifier("reportDataSource")
    private DataSource reportDataSource;

    @Primary
    @Bean(name = "entityManagerReport")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return entityManagerFactoryReport(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryReport")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryReport (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(reportDataSource)
                .properties(getReportProperties(reportDataSource))
                .packages("com.u8.sum.domain.report") //设置实体类所在位置
                .persistenceUnit("reportPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String,String> getReportProperties(DataSource dataSource){
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerReport")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryReport(builder).getObject());
    }

}
