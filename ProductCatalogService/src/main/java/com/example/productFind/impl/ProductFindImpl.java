package com.example.productFind.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.productFind.ProductFind;
import com.example.productInfo.ProductInfo;

public class ProductFindImpl implements ProductFind{
	
	private JdbcTemplate jdbcTemplate;

	    public ProductFindImpl(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
 @Override
 public List<ProductInfo> findByTypeAndName(String type, String name) {
       return jdbcTemplate.query("select * from product where type=? and name =? ", productInfoRowMapper, type, name);
	    }
 @Override
 public List<ProductInfo> findByType(String type) {
     return jdbcTemplate.query("select * from product where type=?", productInfoRowMapper, type);
 }
 @Override
 public List<ProductInfo> findAll() {
     return jdbcTemplate.query("select * from product", productInfoRowMapper);
 }

	
	  @Override public void delete(long id) {
	  jdbcTemplate.update("delete from product where id= ?", id);
	    }
	  
	  @Override
     public void save(ProductInfo productInfo) {
     jdbcTemplate.update("insert into product values (?,?,?)",
             productInfo.getId(), productInfo.getName(), productInfo.getType());
 }	

 private RowMapper<ProductInfo> productInfoRowMapper = new RowMapper<ProductInfo>() {
     @Override
     public ProductInfo mapRow(ResultSet resultSet, int i) throws SQLException {
         ProductInfo productInfo = new ProductInfo();
         productInfo.setId(resultSet.getLong("id"));
         productInfo.setName(resultSet.getString("name"));
         productInfo.setType(resultSet.getString("type"));
         return productInfo;
     }
 };
  
}
