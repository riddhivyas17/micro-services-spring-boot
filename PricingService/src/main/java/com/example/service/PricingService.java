package com.example.service;

import java.util.List;

import com.example.productInfo.ProductInfo;

public interface PricingService {
	 String getPrice(List<ProductInfo> productVos);
}
