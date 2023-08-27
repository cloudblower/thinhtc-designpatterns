package com.thinhtc.factories;

import com.thinhtc.books.Book;
import com.thinhtc.books.FictionBook;

        public class FictionBookFactory implements BookFactory {
    @Override
    public Book createBook(String title) {
        return new FictionBook(title);
    }
}
