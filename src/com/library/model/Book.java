package com.library.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

    private final String isbn;
    private final String title;
    private final String author;
    private final int publicationYear;

    private volatile boolean available = true;
    private final Lock lock = new ReentrantLock();

    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public boolean tryCheckout() {
        if (!lock.tryLock()) return false;

        try {
            if (!available) return false;
            available = false;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public void markReturned() {
        lock.lock();
        try {
            available = true;
        } finally {
            lock.unlock();
        }
    }

    public boolean isAvailable() { return available; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}