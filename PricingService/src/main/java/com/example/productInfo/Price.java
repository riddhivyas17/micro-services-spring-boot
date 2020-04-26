package com.example.productInfo;

public class Price {

	 private Long id;

	    private Long productId;

	    private Double price;

	    public Price() {
	    }

	    public Price(Long productId, Double price) {
	        this.productId = productId;
	        this.price = price;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Long getProductId() {
	        return productId;
	    }

	    public void setProductId(Long productId) {
	        this.productId = productId;
	    }

	    public Double getPrice() {
	        return price;
	    }

	    public void setPrice(Double price) {
	        this.price = price;
	    }

	    @Override
	    public String toString() {
	        return "Price{" +
	                "id=" + id +
	                ", productId=" + productId +
	                ", price=" + price +
	                '}';
	    }
}
