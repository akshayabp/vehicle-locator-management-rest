package org.apawaskar.vehiclelocator.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfig {

	  //@Bean
	  public DataSource dataSource() {
	    EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
	    edb.setType(EmbeddedDatabaseType.H2);
	    //edb.addScript("db/jpa/schema.sql");
	    //edb.addScript("db/jpa/test-data.sql");
	    EmbeddedDatabase embeddedDatabase = edb.build();
	    return embeddedDatabase;
	  }

	  @Bean
	  public LocalContainerEntityManagerFactoryBean emf(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
	    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	    emf.setDataSource(dataSource);
	    emf.setPersistenceUnitName("vehicle-locator-pu");
	    emf.setJpaVendorAdapter(jpaVendorAdapter);
	    emf.setPackagesToScan("org.apawaskar.vehiclelocator.domain");
	    return emf;
	  }
	  
	  //@Bean
	  public JpaVendorAdapter jpaVendorAdapter() {
	    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    adapter.setDatabase(Database.H2);
	    adapter.setShowSql(true);
	    adapter.setGenerateDdl(false);
	    adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
	    return adapter;
	  }
	
}
