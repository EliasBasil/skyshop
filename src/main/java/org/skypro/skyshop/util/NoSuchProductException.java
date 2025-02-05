package org.skypro.skyshop.util;

public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException() {
        super("No such product exists");
    }
}
