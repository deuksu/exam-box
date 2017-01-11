package com.exam.box.standalone.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement  //replace to <tx:*>
@ComponentScan(
      basePackages="com.exam.box", 
      excludeFilters= {@ComponentScan.Filter(Controller.class),@ComponentScan.Filter(Service.class)})
public class AppConfig {

  @Bean(destroyMethod="shutdown")
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
                //.setName("bookDB")
                .setType(EmbeddedDatabaseType.H2)
                //.addScript("classpath:book-schema.sql")
                .build();
  }
  
  /**
  @Bean
  public DataSource dataSource() {
      SimpleDriverDataSource ds = new SimpleDriverDataSource();
      ds.setDriverClass(org.h2.Driver.class);
      ds.setUrl("jdbc:h2:mem:testdb");
      ds.setUsername("sa");
      //ds.setPassword();
      return ds;
  }
  **/
  
  /**
  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }
  
  @Bean
  public PlatformTransactionManager platformTransactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }   
  **/
  
  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setJpaVendorAdapter(hibernateJpaVendorAdapter());
    em.setDataSource(dataSource());
    em.setPackagesToScan("com.exam.box.standalone.domain");

    return em;
  }
  
  @Bean
  public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
      HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
      hibernateJpaVendorAdapter.setShowSql(true);
      return hibernateJpaVendorAdapter;
  }
  

  @Bean
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory().getObject());
    jpaTransactionManager.setDataSource(dataSource());
    return jpaTransactionManager;
  }
}
