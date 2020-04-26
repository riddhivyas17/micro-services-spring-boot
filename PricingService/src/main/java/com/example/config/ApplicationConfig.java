package com.example.config;

import javax.sql.DataSource;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.client.RestTemplate;

import com.example.controller.PricingController;
import com.example.productFind.PricingFind;
import com.example.productFind.impl.PricingFindImpl;
import com.example.service.PricingService;
import com.example.service.impl.PricingServiceImpl;

@Configuration
public class ApplicationConfig {

	
	  @Bean
	    public PricingController pricingController(final LoadBalancerClient loadBalancerClient, final PricingService pricingService) {
	        return new PricingController(loadBalancerClient, pricingService);
	    }

	    @Bean
	    public PricingService pricingService(final PricingFind pricingFind) {
	        return (PricingService) new PricingServiceImpl(pricingFind);
	    }

	    @LoadBalanced
	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
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
	    public PricingFind pricingFind(final JdbcTemplate jdbcTemplate) {
	        return (PricingFind) new PricingFindImpl(jdbcTemplate);
	    }

}
