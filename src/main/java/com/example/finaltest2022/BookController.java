package com.example.finaltest2022;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

import static java.lang.Integer.parseInt;

public class BookController {

    @FXML
    private TableView table;
    @FXML
    public Button addBook_Brn;

    @FXML
    public Button filter_btn;

    @FXML
    public Button delete_btn;

    @FXML
    public TextField bookID_txtFld, BookTitle_txtFld, Author_txtFld, Category_txtFld, Year_txtFld;

    @FXML
    private TableColumn bookID_col, bookTitle_col, category_col, year_col, author_col;

    @FXML
    private String message;

    public void OnFilterButton(ActionEvent actionEvent) throws SQLException {
        DBUtil.query("SELECT * Book");
        populateData();
    }
    public void OnAddButton(ActionEvent actionEvent) throws SQLException {
        DBUtil.addBook("Book", parseInt(bookID_txtFld.getText()), BookTitle_txtFld.getText(), Author_txtFld.getText(), Category_txtFld.getText(), parseInt(Year_txtFld.getText()));
        populateData();
    }
    public void OnDeleteButton(ActionEvent actionEvent) throws SQLException {
        Book book = (Book) table.getSelectionModel().getSelectedItem();
        DBUtil.deleteData("Book", book.getBook_ID());
        populateData();

    }

    private void populateData() throws SQLException {
        ResultSet rs = DBUtil.query("SELECT * FROM Book");

        ObservableList <Book> books = FXCollections.observableArrayList();

        while (rs.next())
        {
            Book book = new Book(rs.getInt("book_ID"), rs.getString("book_author"), rs.getString("book_title"), rs.getString("book_category"), rs.getInt("p_year"));
            book.add(book);
        }
        bookID_col.setCellValueFactory(new PropertyValueFactory("book_id"));
        author_col.setCellValueFactory(new  PropertyValueFactory("book_author"));
        bookTitle_col.setCellValueFactory(new PropertyValueFactory("book_title"));
        category_col.setCellValueFactory(new PropertyValueFactory("book_category"));
        year_col.setCellValueFactory(new PropertyValueFactory("p_year"));


        table.getItems().clear();

        table.getItems().addAll(books);
    }








}
