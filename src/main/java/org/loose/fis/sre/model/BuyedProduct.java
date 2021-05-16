package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class BuyedProduct {

    @Id
    private String buyedproductName;
    private String buyedproductDescription;
    private String buyedproductSize;
    private String buyedproductPrice;
    private String photo;
    private String buyedsellerName;
    private String buyerName;


    public BuyedProduct(String productName, String productDescription, String productSize, String productPrice,String sellerName,String buyerName) {
        this.buyedproductName = productName;
        this.buyedproductDescription = productDescription;
        this.buyedproductSize = productSize;
       // this.photo=photo;
        this.buyedproductPrice = productPrice;
        this.buyedsellerName=sellerName;
        this.buyerName=buyerName;
    }

    public BuyedProduct() {
    }

    public String getbuyedProductName() {
        return buyedproductName;
    }
    public String getbuyedBuyerName() {
        return buyerName;
    }
    public String getbuyedProductDescription() {
        return buyedproductDescription;
    }
    public String getbuyedProductSize() {
        return buyedproductSize;
    }
    public String getbuyedProductPrice() {
        return buyedproductPrice;
    }
    public String getbuyedSellerName() {
        return buyedsellerName;
    }
    public String getbuyerName() {
        return buyerName;
    }
    public String getPhoto() { return photo;  }
}
