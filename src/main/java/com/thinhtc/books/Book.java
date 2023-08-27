package com.thinhtc.books;

import com.thinhtc.observers.BookObserver;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private boolean isBorrowed;
    private List<BookObserver> observers = new ArrayList<>();

    public Book(String title) {
        this.title = title;
        this.isBorrowed = false;
    }

    public void borrowBook() {
        isBorrowed = true;
        notifyObservers();
    }

    public void returnBook() {
        isBorrowed = false;
        notifyObservers();
    }

    public void addObserver(BookObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (BookObserver observer : observers) {
            observer.update(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}


