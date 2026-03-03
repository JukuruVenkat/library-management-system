package com.library.model;

import com.library.util.IdGenerator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Branch {

    private final String id;
    private final String name;
    private final Map<String, Book> inventory = new ConcurrentHashMap<>();

    public Branch(String name) {
        this.id = "BR-" + IdGenerator.generate();
        this.name = name;
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        inventory.remove(isbn);
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public String getId() { return id; }
    public String getName() { return name; }
}