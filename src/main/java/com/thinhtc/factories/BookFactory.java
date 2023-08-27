package com.thinhtc.factories;

import com.thinhtc.books.Book;

public interface BookFactory {
    Book createBook(String title);
}