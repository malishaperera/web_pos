package lk.ijse.web_pos_backend.config;

import jakarta.persistence.EntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "lk.ijse.web_pos_backend")
@EnableJpaRepositories(basePackages = "lk.ijse.web_pos_backend")
@EnableTransactionManagement
public class WebAppRootConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /** Configures the DataSource to connect to the 'Web_pos' MySQL database with the provided details. */
    @Bean
    public DataSource dataSource() {
        var dmds = new DriverManagerDataSource();
        dmds.setDriverClassName("com.mysql.jdbc.Driver");
        dmds.setUrl("jdbc:mysql://localhost:3306/web_pos?createDatabaseIfNotExist=true");
        dmds.setUsername("root");
        dmds.setPassword("Malisha@20");
        return dmds;
    }

    /** Configures the EntityManagerFactory to manage JPA entities using Hibernate and sets up the database connection. */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("lk.ijse.web_pos_backend.entity");
        factory.setDataSource(dataSource());
        return factory;
    }

    /** Configures the transaction manager to manage JPA transactions using the specified EntityManagerFactory. */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

}
