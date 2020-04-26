package com.example.productFind;

import java.util.List;

import com.example.productInfo.ProductInfo;


public interface ProductFind {

    List<ProductInfo> findByTypeAndName(String type, String name);

    List<ProductInfo> findByType(String type);

    List<ProductInfo> findAll();

	 void delete(long id); 

    void save(ProductInfo ProductInfo);

}
