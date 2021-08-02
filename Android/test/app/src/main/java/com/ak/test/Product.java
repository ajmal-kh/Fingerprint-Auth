package com.ak.test;

public class Product {

    String pp2_pn;
    Integer pp2_price;
    public Product(String pname, Integer price) {
        pp2_pn = pname;
        pp2_price = price;
    }

    public String getPname() {
        return pp2_pn;
    }

    public Integer getPrice() {
        return pp2_price;
    }
}
