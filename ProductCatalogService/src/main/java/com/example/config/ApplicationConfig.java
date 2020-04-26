package com.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.example.controller.ProductController;
import com.example.productFind.ProductFind;
import com.example.productFind.impl.ProductFindImpl;
import com.example.service.ProductService;
import com.example.service.impl.ProductServiceImpl;

@Configuration
public class ApplicationConfig {
	
	 @Bean
	    public ProductServiceImpl productService(final ProductFind productFind) {
	        return new ProductServiceImpl(productFind);
	    }
	 
	  @Bean
	    public ProductController productController(final ProductService productService) {
	        return new ProductController(productService);
	    }
	  
	  @Bean
	    public DataSource dataSource() {
	        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
	        EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2)
	                .addScript("schema.sql").addScript("data.sql").build();
	        return embeddedDatabase;
	    }
	  
	  @Bean
	    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
	        return new JdbcTemplate(dataSource);
	    }
	  
	  @Bean
	    public ProductFindImpl productFind(final JdbcTemplate jdbcTemplate) {
	        return new ProductFindImpl(jdbcTemplate);
	    }


}
