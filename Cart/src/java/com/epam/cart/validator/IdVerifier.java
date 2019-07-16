package com.epam.cart.validator;

public class IdVerifier {

    public boolean validate(String id) {
        boolean result = true;
        for (int i = 0; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                result = false;
            }
        }
        return result;
    }
}
