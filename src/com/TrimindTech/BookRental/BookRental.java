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
                    DBBorrowerList blist= new DBBorrowerList();
                    blist.insertBorrowLIST();
                    DeleteBorrowList db= new DeleteBorrowList();
                    db.deleteBorrowLists();
                    break;
                case 6:
                    BookReturn returnbooks= new BookReturn();
                    returnbooks.bookreturn();
                    break;
                case 7:
                    DisplayBorrowList displayList= new DisplayBorrowList();
                    displayList.DisplayBList();
                    break;
                case 8:
                    exit(0);
                    System.out.println("choose correct option");
            }
            printOptions();
            option = sc.nextInt();
        } while (option != 8);

    }

    public static void bList () {

        System.out.println("the book details are" + borrower.getAllBorrowerList().toString());

    }
}

