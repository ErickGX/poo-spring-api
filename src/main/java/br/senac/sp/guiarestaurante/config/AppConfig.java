package br.senac.sp.guiarestaurante.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/guiarestaurante");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
		adapter.setPrepareConnection(true);
		adapter.setGenerateDdl(true);
		adapter.setShowSql(true); //habilita o log de criação do bd
		return adapter;
	}
	
}
