package com.barton;

public class Book {
    /**
     * Primitive Data Types
     */
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut;
    int dayCheckedOut;
    /**
     * Constructor
     * This keyword can be used to refer to instance variables in a current class
     * Invoke or initiate current class constructor
     * It can be passed as an argument
     * It can be passed as an argument in the constructor call
     * Can be used to return the current class instance
     */
    public Book(String bookTitle, int bookPageCount, int bookISBN){
        this.title = bookTitle;
        this.pageCount = bookPageCount;
        this.ISBN = bookISBN;
        isCheckedOut = false;
    }
    /**
     * Instance methods
     */
    public String getTitle() {
        return this.title;
    }
    public int getPageCount() {
        return this.pageCount;
    }
    public int getISBN() {
        return this.ISBN;
    }
    public boolean getisCheckedOut() {
        return this.isCheckedOut;
    }
    public int getDayCheckedOut() {
        return this.dayCheckedOut;
    }
    public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut) {
        this.isCheckedOut = newIsCheckedOut;
        setDayCheckedOut(currentDayCheckedOut);
    }
    private void setDayCheckedOut(int day) {
        this.dayCheckedOut = day;
    }
}