package com.thinhtc.factories;

import com.thinhtc.books.Book;
import com.thinhtc.books.NonFictionBook;

public class NonFictionBookFactory implements BookFactory {
    @Override
    public Book createBook(String title) {
        return new NonFictionBook(title);
    }
}
