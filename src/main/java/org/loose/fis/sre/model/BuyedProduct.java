package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class BuyedProduct {

    @Id
    private String productName;
    private String productDescription;
    private String productSize;
    private String productPrice;
    private String photo;
    private String sellerName;
    private String buyerName;


    public BuyedProduct(String productName, String productDescription, String productSize, String productPrice,String sellerName,String buyerName) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productSize = productSize;
       // this.photo=photo;
        this.productPrice = productPrice;
        this.sellerName=sellerName;
        this.buyerName=buyerName;
    }

    public BuyedProduct() {
    }

    public String getProductName() {
        return productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public String getProductSize() {
        return productSize;
    }
    public String getProductPrice() {
        return productPrice;
    }
    public String getSellerName() {
        return sellerName;
    }
    public String getPhoto() { return photo;  }
}
