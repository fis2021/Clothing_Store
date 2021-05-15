package org.loose.fis.sre.services;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.FieldNotCompletedException;
import org.loose.fis.sre.exceptions.PasswordConfirmationException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.WeakPasswordException;
import org.loose.fis.sre.model.Product;
import org.loose.fis.sre.model.User;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class AddProductService {

    private static ObjectRepository<Product> productsRepository;


    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("product.db").toFile())
                .openOrCreate("prod", "prod");

        productsRepository = database.getRepository(Product.class);
    }
    public static void addProduct(String productName, String productDescription, String size, String photoPath)  throws  FieldNotCompletedException {
        FieldsCompleted(productName, productDescription, size);
        productsRepository.insert(new Product(productName,  productDescription, size, photoPath));
    }
    public static void FieldsCompleted(String productName, String productDescription, String size) throws FieldNotCompletedException {
        if (productName.trim().isEmpty() || productDescription.trim().isEmpty() || size.trim().isEmpty()) {
            throw new FieldNotCompletedException();
        }
    }
        public static ObjectRepository<Product>  getProductsRepository(){
            return productsRepository;
        }

}
