package com.example.controller;

import java.net.URI;
import java.util.Arrays;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.productInfo.ProductInfo;
import com.example.service.PricingService;
import com.example.util.ServiceName;

@RestController
@RequestMapping("products/price")
public class PricingController {

	 private final PricingService pricingService;

	    private final LoadBalancerClient loadBalancerClient;

	    public PricingController(LoadBalancerClient loadBalancerClient, PricingService pricingService) {
	        this.loadBalancerClient = loadBalancerClient;
	        this.pricingService = pricingService;
	    }

	    @RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	    public String getPrice(@RequestParam(value = "name", required = true) final String name, @RequestParam(value = "type", required = true) final String type) {
	        ServiceInstance serviceInstance = loadBalancerClient.choose(ServiceName.PRODUCT_CATALOG_SERVICE.getName());
	        URI uri = serviceInstance.getUri();
	        String url = uri.toString() + "/products/search?name=" + name + "&type=" + type;
	        ProductInfo[] productInfos = (new RestTemplate()).getForObject(url, ProductInfo[].class);
	        return pricingService.getPrice(Arrays.asList(productInfos));
	    }
	
}
