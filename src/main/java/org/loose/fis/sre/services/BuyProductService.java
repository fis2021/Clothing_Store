package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.BuyedProduct;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class BuyProductService {

    private static ObjectRepository<BuyedProduct> buyedProductsRepository;


    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("productbuyed.db").toFile())
                .openOrCreate("com", "com");

        buyedProductsRepository = database.getRepository(BuyedProduct.class);
    }
    public static void buyProduct(String productName, String productDescription, String size,String productPrice,String sellerName, String buyerName)  {
        buyedProductsRepository.insert(new BuyedProduct(productName,  productDescription, size, productPrice,sellerName,buyerName));
    }


    public static ObjectRepository<BuyedProduct>  getbuyedProductRepository(){
        return buyedProductsRepository;
    }

}
