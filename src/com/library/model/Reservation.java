package com.library.model;

import com.library.observer.Observer;
import com.library.observer.Subject;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reservation implements Subject {

    private final Book book;
    private final Patron patron;
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    public Reservation(Book book, Patron patron) {
        this.book = book;
        this.patron = patron;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }

    public Book getBook() { return book; }
    public Patron getPatron() { return patron; }
}