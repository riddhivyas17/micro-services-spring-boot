package com.example.productFind;

import com.example.productInfo.Price;

public interface PricingFind {
	Price findByProductId(Long id);
}
