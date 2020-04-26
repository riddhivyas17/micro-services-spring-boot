package com.example.service.impl;

import java.util.List;

import com.example.productFind.ProductFind;
import com.example.productInfo.ProductInfo;
import com.example.service.ProductService;


public class ProductServiceImpl implements ProductService {
	
	  private final ProductFind productFind;

	    public ProductServiceImpl(ProductFind productFind) {
	        this.productFind = productFind;
	    }

	    @Override
	    public void addProduct(ProductInfo productVo) {
	        final ProductInfo ProductInfo = new ProductInfo();
	        ProductInfo.setName(productVo.getName());
	        ProductInfo.setType(productVo.getType());
	        productFind.save(ProductInfo);
	    }

	    @Override
	    public List<ProductInfo> getProducts() {
	        return productFind.findAll();
	    }
	    
	
	    @Override 
	    public void deleteProduct(long id) 
	    { productFind.delete(id); }
	 
	    @Override
	    public List<ProductInfo> getProductsByTypeAndName(String type, String name) {
	        return productFind.findByTypeAndName(type, name);
	    }
	    
	    @Override
	    public List<ProductInfo> getProductsByType(String type) {
	        return productFind.findByType(type);
	    }
	    
}
