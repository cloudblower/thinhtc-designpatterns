package com.thinhtc;

import com.thinhtc.books.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private static LibraryManager instance;
    private List<Book> books;

    private LibraryManager() {
        books = new ArrayList<>();
    }

    public static LibraryManager getInstance() {
        if (instance == null) {
            instance = new LibraryManager();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

}

