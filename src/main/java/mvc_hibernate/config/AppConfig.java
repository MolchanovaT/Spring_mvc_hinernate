package mvc_hibernate.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Properties;

@Configuration
@ComponentScan("mvc_hibernate")
@EnableTransactionManagement
public class AppConfig {

   @Bean
   public DataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("org.postgresql.Driver");
      dataSource.setUrl("jdbc:postgresql://localhost:5432/spring_hibernate_db");
      dataSource.setUsername("root");
      dataSource.setPassword("root");
      return dataSource;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
      emf.setDataSource(dataSource()); // Подключаем DataSource
      emf.setPackagesToScan("mvc_hibernate.model");
      emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

      Properties props = new Properties();
      props.setProperty("hibernate.hbm2ddl.auto", "update");
      props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
      props.setProperty("hibernate.show_sql", "true");
      props.setProperty("hibernate.format_sql", "true");

      emf.setJpaProperties(props);
      return emf;
   }

   @Bean
   public InternalResourceViewResolver viewResolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }

   @Bean
   public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
      return new JpaTransactionManager(emf);
   }
}
