package com.thinhtc.observers;

import com.thinhtc.books.Book;

public class UserObserver implements BookObserver {
    private String userName;

    public UserObserver(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(Book book) {
        // Gửi thông báo cho người dùng khi trạng thái của Sách thay đổi
        System.out.println("Đã gửi thông báo cho người dùng " + userName
                + ": Sách '" + book.getTitle() + (book.isBorrowed() ? "' đã được mượn!": "' đã được trả!"));

    }
}

