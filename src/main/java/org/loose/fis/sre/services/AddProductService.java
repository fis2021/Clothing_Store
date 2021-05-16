package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.FieldNotCompletedException;
import org.loose.fis.sre.model.Product;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class AddProductService {

    private static ObjectRepository<Product> productsRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("product2.db").toFile())
                .openOrCreate("prod", "prod");

        productsRepository = database.getRepository(Product.class);
    }
    public static void addProduct(String productName, String productDescription, String size, String photoPath,String productPrice,String sellerName)  throws  FieldNotCompletedException {
        FieldsCompleted(productName, productDescription, size);
        productsRepository.insert(new Product(productName,  productDescription, size, photoPath, productPrice,sellerName));
    }
    public static void FieldsCompleted(String productName, String productDescription, String size) throws FieldNotCompletedException {
        if (productName.trim().isEmpty() || productDescription.trim().isEmpty() || size.trim().isEmpty()) {
            throw new FieldNotCompletedException();
        }
    }
    public static void deleteAd(String title, String validationUsername) throws FieldNotCompletedException
    {
        Product product = new Product();
        for(Product i : productsRepository.find()) {
            if (Objects.equals(title, i.getProductName()) && Objects.equals(validationUsername, i.getSellerName())) {
                product = i;
            }
        }
        productsRepository.remove(product);
    }
        public static ObjectRepository<Product>  getProductsRepository(){
            return productsRepository;
        }

}
