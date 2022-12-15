package com.example.finaltest2022;

public class Book {

    int book_ID;

    String book_category;

    String book_title;

    int p_year;

    String book_author;

    public Book (int book_ID, String book_category, String book_title, int p_year, String book_author)
    {
        this.book_ID = book_ID;
        this.book_category = book_category;
        this.book_title = book_title;
        this.p_year = p_year;
        this.book_author = book_author;
    }

    public Book(int book_id, String book_author) {
    }

    public Book(int book_id, String book_author, String book_title, String book_category, int p_year) {
    }

    public int getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(int book_ID) {
        this.book_ID = book_ID;
    }

    public String getBook_category() {
        return book_category;
    }

    public void setBook_category(String book_category) {
        this.book_category = book_category;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public int getP_year() {
        return p_year;
    }

    public void setP_year_year(int p_year) {
        this.p_year = p_year;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public void add(Book book) {
    }
}
