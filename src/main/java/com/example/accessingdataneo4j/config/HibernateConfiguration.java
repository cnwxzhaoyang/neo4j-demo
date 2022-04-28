package com.example.accessingdataneo4j.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Map;

/**
 * description:
 *
 * @author MorningSun
 * @version 1.0
 * @since JDK1.8
 * date 2022/4/27 19:16
 */
@Configuration
@ConditionalOnProperty(name = "spring.datasource.driver-class-name", havingValue = "oracle.jdbc.driver.OracleDriver")
public class HibernateConfiguration implements HibernatePropertiesCustomizer {

    @Resource
    JpaInterceptor jpaInterceptor;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.session_factory.statement_inspector", jpaInterceptor);
    }
}
