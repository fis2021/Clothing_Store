package org.loose.fis.sre.exceptions;

public class WeakPasswordException extends Exception {

    public WeakPasswordException() {
        super("Password does not contain at least 6 characters !");

    }
}
