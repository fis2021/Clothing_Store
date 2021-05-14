package org.loose.fis.sre.exceptions;

public class UsernameDoesNotExistsException extends Exception {


    public UsernameDoesNotExistsException() {
        super("An account with that username doesn't exists!");
    }
}
