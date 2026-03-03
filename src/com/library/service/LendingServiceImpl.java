package com.library.service;

import com.library.model.*;

public class LendingServiceImpl implements LendingService {

    @Override
    public Loan checkoutBook(Book book, Patron patron) {

        if (!book.tryCheckout()) {
            throw new IllegalStateException("Book unavailable");
        }

        Loan loan = new Loan(book, patron);
        patron.addLoan(loan);
        return loan;
    }

    @Override
    public void returnBook(Loan loan) {
        loan.returnBook();
    }
}