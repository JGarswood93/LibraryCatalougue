package com.barton;

import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {
    /**
     * Book Collection
     * Current Day
     * Length of Checkout Period
     * Initial Late Fee
     * Pay Day Late Fee
      */
    Map<String, Book> bookCollection = new HashMap<String, Book>();
    int currentDay = 0;
    int lengthOfCheckOutPeriod = 7;
    double initialLateFee = 0.50;
    double feePerLateDay = 1.00;


    public LibraryCatalogue(Map<String, Book> collection){
        this.bookCollection = collection;
    }

    /**
     * Constructor
     *
     * @param collection
     * @param lengthOfCheckOutPeriod
     * @param initialLateFee
     * @param feePerLateDay
     */
    public LibraryCatalogue(Map<String, Book> collection, int lengthOfCheckOutPeriod,
                            double initialLateFee, double feePerLateDay) {
        this.bookCollection = collection;
        this.lengthOfCheckOutPeriod = lengthOfCheckOutPeriod;
        this.initialLateFee = initialLateFee;
        this.feePerLateDay = feePerLateDay;

    }

    public Map<String, Book> getBookCollection() {
        return bookCollection;
    }
    public Book getBook(String bookTitle) {
        return getBookCollection().get(bookTitle);

    }

    public int getCurrentDay() {
        return currentDay;
    }

    public int getLengthOfCheckOutPeriod() {
        return lengthOfCheckOutPeriod;
    }

    public double getInitialLateFee() {
        return initialLateFee;
    }

    public double getFeePerLateDay() {
        return feePerLateDay;
    }
    public void nextDay() {
        currentDay++;
    }

    public void setDay(int day) {
        currentDay = day;
    }

    /**
     * Checkout and Return Methods
     *
     * Instance Methods
     */
    public void checkOut(String title) {
        Book book = getBook(title);
        if(book.getisCheckedOut()){
            sorryBookAlreadyCheckedOut(book);
        }else {
            book.setIsCheckedOut(true, currentDay);
            System.out.println("You just checked out " + title + ". It is due on day " +
                    (getCurrentDay() + getLengthOfCheckOutPeriod() + "."));
        }
    }
    public void returnBook(String title) {
        Book book = getBook(title);
        int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfCheckOutPeriod());
        if(daysLate > 0) {
            System.out.println("You owe the library $" + (getInitialLateFee() + daysLate * getFeePerLateDay()) + " because your book is " + daysLate + "days overdue.");
        } else {
            System.out.println("Book Returned. Thank you");
        }
        book.setIsCheckedOut(false, -1);
    }
    public void sorryBookAlreadyCheckedOut(Book book) {
        System.out.println("Sorry, " + book.getTitle() + " is already checked out" + "It should be back on day " + (book.getDayCheckedOut() + getLengthOfCheckOutPeriod() + ". "));
    }

    /**
     * Where everything is used
     *
     * @param args
     */
    public static void main(String[] args) {
    Map<String, Book> bookCollection = new HashMap<String, Book>();
    Book Richard = new Book("Richard Dawkins", 239, 12222233);
    bookCollection.put("Richard Dawkins", Richard);
    LibraryCatalogue lib = new LibraryCatalogue(bookCollection);
    lib.checkOut("Richard Dawkins");
    lib.nextDay();
    lib.nextDay();
    lib.checkOut("Richard Dawkins");
    lib.setDay(6);
    lib.returnBook("Richard Dawkins");
    lib.checkOut("Richard Dawkins");
    }
}
