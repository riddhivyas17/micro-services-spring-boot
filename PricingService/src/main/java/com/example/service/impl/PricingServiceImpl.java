package com.example.service.impl;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.example.productFind.PricingFind;
import com.example.productInfo.Price;
import com.example.productInfo.ProductInfo;
import com.example.service.PricingService;

public class PricingServiceImpl implements PricingService{

	 public static final String NO_PRODUCT_FOUND = "No Product Found";
	    private final PricingFind pricingFind;

	    public PricingServiceImpl(PricingFind pricingFind) {
	        this.pricingFind = pricingFind;
	    }

	    @Override
	    public String getPrice(final List<ProductInfo> productVos) {
	        if (CollectionUtils.isEmpty(productVos)) {
	            return NO_PRODUCT_FOUND;
	        }
	        ProductInfo productVo = productVos.get(0);
	        final Price price = pricingFind.findByProductId(productVo.getId());
	        return price == null ? NO_PRODUCT_FOUND : price.getPrice() == null ? NO_PRODUCT_FOUND : price.getPrice().toString();
	    }
}
