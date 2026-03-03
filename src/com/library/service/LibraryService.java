package com.library.service;

import com.library.model.*;

import java.util.Optional;

public interface LibraryService {

    void addBranch(Branch branch);
    Optional<Branch> findBranch(String branchId);

    void registerPatron(Patron patron);
    Optional<Patron> findPatron(String patronId);
}