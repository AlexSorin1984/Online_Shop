package com.sorin.onlineshop.model;

public class ProductRequest {
    private String product;
    private Long price;

    public ProductRequest() {
    }

    public ProductRequest(String product, Long price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
