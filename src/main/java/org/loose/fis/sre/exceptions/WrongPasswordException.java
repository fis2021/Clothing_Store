package org.loose.fis.sre.exceptions;

public class WrongPasswordException extends Exception {

    public WrongPasswordException() {
        super("Wrong password! ");
    }
}
