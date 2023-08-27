package com.thinhtc;

import com.thinhtc.books.Book;
import com.thinhtc.factories.BookFactory;
import com.thinhtc.factories.FictionBookFactory;
import com.thinhtc.factories.NonFictionBookFactory;
import com.thinhtc.observers.BookObserver;
import com.thinhtc.observers.UserObserver;
import com.thinhtc.ui.LibraryUI;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = LibraryManager.getInstance();
        BookFactory fictionFactory = new FictionBookFactory();
        BookFactory nonFictionFactory = new NonFictionBookFactory();
        Book fictionBook1 = fictionFactory.createBook("Sách Khoa học viễn tưởng");
        Book nonFictionBook1 = nonFictionFactory.createBook("Sách Lịch sử");

        BookObserver user1 = new UserObserver("Người dùng 1");
        BookObserver user2 = new UserObserver("Người dùng 2");

        fictionBook1.addObserver(user1);

        libraryManager.getBooks().add(fictionBook1);
        libraryManager.getBooks().add(nonFictionBook1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LibraryUI libraryUI = new LibraryUI(libraryManager);
                libraryUI.show();
            }
        });
    }
}