package org.loose.fis.sre.exceptions;

public class ProductDoesntExistException extends Exception{

    public ProductDoesntExistException() {

        super("Username does not exist");
    }
}
