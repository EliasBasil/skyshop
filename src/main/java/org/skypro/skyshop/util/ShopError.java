package org.skypro.skyshop.util;

public class ShopError {
    private final String code = "PRODUCT_NOT_FOUND: ERROR 404";
    private final String message = "No such product exists";

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
