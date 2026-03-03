package com.library.model;

import com.library.util.IdGenerator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Patron {

    private final String id;
    private final String name;
    private final List<Loan> borrowingHistory = new CopyOnWriteArrayList<>();

    public Patron(String name) {
        this.id = "PAT-" + IdGenerator.generate();
        this.name = name;
    }

    public void addLoan(Loan loan) {
        borrowingHistory.add(loan);
    }

    public List<Loan> getBorrowingHistory() {
        return List.copyOf(borrowingHistory);
    }

    public String getId() { return id; }
    public String getName() { return name; }
}