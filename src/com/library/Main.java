package com.library;

import com.library.model.*;
import com.library.service.*;

public class Main {

    public static void main(String[] args) {

        LibraryService libraryService = new LibraryServiceImpl();
        LendingService lendingService = new LendingServiceImpl();

        Branch branch = new Branch("Downtown");
        libraryService.addBranch(branch);

        Book book = new Book("ISBN-1", "Clean Code", "Robert Martin", 2008);
        branch.addBook(book);

        Patron patron = new Patron("Venkat");
        libraryService.registerPatron(patron);

        Loan loan = lendingService.checkoutBook(book, patron);
        System.out.println("Book checked out successfully.");

        lendingService.returnBook(loan);
    }
}