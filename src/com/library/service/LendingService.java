package com.library.service;

import com.library.model.*;

public interface LendingService {

    Loan checkoutBook(Book book, Patron patron);
    void returnBook(Loan loan);
}