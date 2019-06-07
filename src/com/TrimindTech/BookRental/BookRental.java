package com.TrimindTech.BookRental;
import com.TrimindTech.BookRental.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import static java.lang.System.exit;

public class BookRental {
    public int option;
    public static Catalog catalog = new Catalog();
    public static Borrower borrower = new Borrower();
    public static Scanner sc = new Scanner(System.in);

    public static void printOptions() {

        System.out.println("*****Welcome to BookRental System*****");
        System.out.println("[1].Search a book");
        System.out.println("[2].Add a book to catalog");
        System.out.println("[3].Delete book from catalog");
        System.out.println("[4].List of books in the catalog");
        System.out.println("[5].Rent a book");
        System.out.println("[6].Return a book");
        System.out.println("[7].Print out borrower list");
        System.out.println("[8].Exit the program");
        // System.out.println();
        System.out.println("****************************************");

    }
        public static void main (String[]args)throws FileNotFoundException {
        printOptions();
        int option;
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        do {
            switch (option) {
                case 1:
                    SearchQ search= new SearchQ();
                    search.searchDetials();
                    break;
                case 2:
                    InsertionData bb= new InsertionData();
                    bb.insertTest();
                    //addBooks();
                    break;
                case 3:
                    DeleteRec del = new DeleteRec();
                    del.DeleteRec();
                    break;
                case 4:
                    DisplayRecords display= new DisplayRecords();
                    display.displayRecords();
                    break;
                case 5:
                    catalog.rentBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    bList();
                    break;
                case 8:
                    exit(0);
                    System.out.println("choose correct option");
            }
            printOptions();
            option = sc.nextInt();
        } while (option != 8);

    }
    public static void printBorrowList () {
        System.out.println(borrower.getAllBorrowerList().toString());
    }
    public static void returnBook ()
    {
        System.out.println("the book is returned");
        System.out.println("the book details are" + borrower.getAllBorrowerList().toString());
    }
    public static void bList () {

        System.out.println("the book details are" + borrower.getAllBorrowerList().toString());

    }
    public static Book searchBook () {
        System.out.println("enter book name to search");
        String bookname = sc.next();
        Book book = catalog.searchBook(bookname);
        return book;
    }
    public static void borrowerList () {
        BarrowerFile borrowerFile = new BarrowerFile();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter book name to rent");
        String bookName = sc.next();
        borrowerFile.setBookName(bookName);
        System.out.println("entet first name");
        String firstName = sc.next();
        borrowerFile.setFirstName(firstName);
        System.out.println("entet last name");
        String lastName = sc.next();
        borrowerFile.setLastName(lastName);
        System.out.println("entet email id");
        String email = sc.next();
        borrowerFile.setEmail(email);
        System.out.println("enter no.of days to rent");
        int days = sc.nextInt();
        Date date = new Date();
        String todayDate = date.toString();
        borrowerFile.setDate(todayDate);
        borrowerFile.setNoOfDaysLoan(days);
        borrower.addBorrower(borrowerFile);
    }
}

