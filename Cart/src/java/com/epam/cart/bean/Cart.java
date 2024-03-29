package com.epam.cart.bean;

import com.epam.cart.exception.BookException;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface Cart {
    void initialize(String person) throws BookException;

    void initialize(String person, String id) throws BookException;

    void addBook(String title);

    void removeBook(String title) throws BookException;

    List<String> getContents();

    void remove();
}
