package com.thinhtc.ui;

import com.thinhtc.LibraryManager;
import com.thinhtc.books.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LibraryUI {
    private JFrame frame;
    private JTextField titleField;
    private JButton borrowButton;
    private JButton returnButton;
    private JTextArea statusTextArea;
    private JTable bookTable;
    private DefaultTableModel tableModel;
    private LibraryManager libraryManager;

    public LibraryUI(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;

        frame = new JFrame("Quản lý thư viện");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        titleField = new JTextField(30);
        borrowButton = new JButton("Mượn sách");
        returnButton = new JButton("Trả sách");
        statusTextArea = new JTextArea(10, 40);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Tên sách: "));
        inputPanel.add(titleField);
        inputPanel.add(borrowButton);
        inputPanel.add(returnButton);

        tableModel = new DefaultTableModel(new String[] { "Tiêu đề", "Đã mượn" }, 0);
        bookTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(bookTable);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(tableScrollPane, BorderLayout.CENTER);
        panel.add(new JScrollPane(statusTextArea), BorderLayout.SOUTH);

        frame.add(panel);

        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrowBook();
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBook();
            }
        });
    }

    public void show() {
        frame.setVisible(true);
        updateTable();
    }

    private void borrowBook() {
        String title = titleField.getText().trim();
        if (!title.isEmpty()) {
            List<Book> books = libraryManager.getBooks();
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
                    book.borrowBook();
                    updateStatus("Đã mượn: " + book.getTitle());
                    updateTable();
                    return;
                }
            }
            updateStatus("Không tìm thấy sách hoặc sách đã được mượn.");
        } else {
            updateStatus("Hãy điền tên sách.");
        }
    }

    private void returnBook() {
        String title = titleField.getText().trim();
        if (!title.isEmpty()) {
            List<Book> books = libraryManager.getBooks();
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title) && book.isBorrowed()) {
                    book.returnBook();
                    updateStatus("Đã trả: " + book.getTitle());
                    updateTable();
                    return;
                }
            }
            updateStatus("Không tìm thấy sách hoặc sách chưa được mượn.");
        } else {
            updateStatus("Hãy điền tên sách.");
        }
    }

    private void updateStatus(String message) {
        statusTextArea.append(message + "\n");
    }

    private void updateTable() {
        List<Book> books = libraryManager.getBooks();
        tableModel.setRowCount(0);
        for (Book book : books) {
            tableModel.addRow(new Object[] { book.getTitle(), book.isBorrowed() ? "Có" : "Không" });
        }
    }
}
