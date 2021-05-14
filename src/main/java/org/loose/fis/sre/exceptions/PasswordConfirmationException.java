package org.loose.fis.sre.exceptions;

public class PasswordConfirmationException extends Exception {

    public PasswordConfirmationException() {
        super("Password confirmation doesn`t match password!");
    }
}