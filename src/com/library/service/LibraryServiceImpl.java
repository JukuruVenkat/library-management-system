package com.library.service;

import com.library.model.*;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryServiceImpl implements LibraryService {

    private final Map<String, Branch> branches = new ConcurrentHashMap<>();
    private final Map<String, Patron> patrons = new ConcurrentHashMap<>();

    @Override
    public void addBranch(Branch branch) {
        branches.put(branch.getId(), branch);
    }

    @Override
    public Optional<Branch> findBranch(String branchId) {
        return Optional.ofNullable(branches.get(branchId));
    }

    @Override
    public void registerPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    @Override
    public Optional<Patron> findPatron(String patronId) {
        return Optional.ofNullable(patrons.get(patronId));
    }
}