package org.skypro.skyshop.controller;

import org.skypro.skyshop.util.NoSuchProductException;
import org.skypro.skyshop.util.ShopError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> handleNoSuchProductException() {
        return ResponseEntity.badRequest().body(new ShopError());
    }
}
