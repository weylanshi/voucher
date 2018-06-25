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
        entityManagerFactoryRef="entityManagerFactoryVoucher",
        transactionManagerRef="transactionManagerVoucher",
        basePackages= { "com.u8.sum.domain.voucher" }) //设置Repository所在位置
public class voucherDatasourceConfig {

    @Autowired
    @Qualifier("voucherDataSource")
    private DataSource voucherDataSource;


    @Bean(name = "entityManagerVoucher")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return entityManagerFactoryVoucher(builder).getObject().createEntityManager();
    }


    @Bean(name = "entityManagerFactoryVoucher")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryVoucher (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(voucherDataSource)
                .properties(getVoucherProperties(voucherDataSource))
                .packages("com.u8.sum.domain.voucher") //设置实体类所在位置
                .persistenceUnit("voucherPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String,String> getVoucherProperties(DataSource dataSource){
        return jpaProperties.getHibernateProperties(dataSource);
    }


    @Bean(name = "transactionManagerVoucher")
     PlatformTransactionManager transactionManagerVoucher(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryVoucher(builder).getObject());
    }

}
