package com.library.model;

import java.time.LocalDate;

public class Loan {

    private final Book book;
    private final Patron patron;
    private final LocalDate checkoutDate;
    private LocalDate returnDate;

    public Loan(Book book, Patron patron) {
        this.book = book;
        this.patron = patron;
        this.checkoutDate = LocalDate.now();
    }

    public void returnBook() {
        book.markReturned();
        this.returnDate = LocalDate.now();
    }

    public Book getBook() { return book; }
    public Patron getPatron() { return patron; }
}