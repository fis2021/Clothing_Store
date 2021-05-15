package org.loose.fis.sre.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.dizitart.no2.objects.Id;

public class Product {

    @Id
    private String productName;
    private String productDescription;
    private String productSize;
    private String photo;



    public Product(String productName, String productDescription, String productSize, String photo) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productSize = productSize;
        this.photo=photo;


    }

    public Product() {
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

}
