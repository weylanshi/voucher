package com.u8.sum.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "reportDataSource")
    @Primary
    @Qualifier("reportDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.report")
    public DataSource reportDataSource(){
       return DataSourceBuilder.create().build();
    }

    @Bean(name = "voucherDataSource")
    @Qualifier("voucherDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.voucher")
    public DataSource voucherDataSource() {
        return DataSourceBuilder.create().build();
    }


}
