package com.example.service;

import java.util.List;

import com.example.productInfo.ProductInfo;


public interface ProductService {

    void addProduct(ProductInfo productVo);

    List<ProductInfo> getProducts();

    void deleteProduct(long id); 

    List<ProductInfo> getProductsByTypeAndName(String type, String name);

    List<ProductInfo> getProductsByType(String type);

	}
