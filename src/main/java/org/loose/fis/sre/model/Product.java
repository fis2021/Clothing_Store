package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class Product {

    @Id
    private String productName;

    private String productDescription;
    private String productSize;
    private String productPrice;
    private String photo;
    private String sellerName;


    public Product(String productName, String productDescription, String productSize, String photo, String productPrice,String sellerName) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productSize = productSize;
        this.photo=photo;
        this.productPrice = productPrice;
        this.sellerName=sellerName;
        this.productName2=productName;
    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public String getProductSize() { return productSize; }
    public String getProductPrice() {
        return productPrice;
    }

    public String getSellerName() {
        return sellerName;
    }
    public String getPhoto() { return photo;  }


    public  String getSellerName() { return sellerName; }
     public String getPhoto() { return photo;  }


}
