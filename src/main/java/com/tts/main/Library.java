package com.tts.main;

import java.util.ArrayList;

public class Library {

   private final String address;
   private final ArrayList<Book> bookList;
   private static String openingHours;
   private final String DEFAULT_HOURS = "Libraries are open daily from 9am to 5pm";

    public Library(String address){
        this.address = address;
        bookList = new ArrayList<>();
        openingHours = DEFAULT_HOURS;
    }

    private String getAddress(){
        return this.address;
    }

    private void addBook(Book book){
        bookList.add(book);
    }

    private static void printOpeningHours(){
        System.out.println(openingHours);
    }

    private void printAddress(){
        System.out.println(getAddress());
    }

    private void borrowBook(String book) {
        boolean available = false;
        for (Book b : bookList) {
            if (b.getTitle().equals(book)) {
                available = true;
                if (b.isBorrowed()) {
                    System.out.println("Sorry, this book has been borrowed.");
                } else {
                    b.borrowed();
                    System.out.printf("You have sucessfully borrowed '%s'%n", b.getTitle());
                }
            }
        }
        if (!available) {
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }


    private void printAvailableBooks() {
        if (!bookList.isEmpty()) {
            for (Book b : bookList) {
                if (!b.isBorrowed()) {
                    System.out.println(b.getTitle());
                }
            }
        } else {
            System.out.println("No books are in this catalog.");
        }

    }

    private void returnBook(String book){
        boolean available = false;
        for (Book b: bookList){
            if (b.getTitle().equals(book)){
                available = true;
                b.returned();
                System.out.printf("You successfully returned '%s'%n", book);
            }
        }
        if(!available) {
            System.out.println("We do not have this book in our catalog to be returned");

        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

}
