package com.TrimindTech.BookRental;
import java.util.*;

public class Catalog extends Book {

    ArrayList<Book> books1=new ArrayList<>();

    public Map<String,Book> bookMap= new HashMap<>();
    Scanner sc=new Scanner(System.in);


    public void addBook(Book book)
    {
        books1.add(book);
        System.out.println("Book is added..."+"\n");
        System.out.println("press any key to display the details of book"+"\n");
        String bookName=sc.next();
        bookMap.put(bookName,book);
    }
    public Map<String,Book> getAllBooks()
    {
        return bookMap;
    }

    public void deleteBook(Book b)
    {
        String name=b.getTitle();
        books1.remove(b);
    }
    public void rentBook()
    {
        Book book=BookRental.searchBook();
        if(book==null){
            System.out.println("Sorry,Book is not available in the store"+"\n");

        }else {
            System.out.println("\n"+"pleaser provide the details of the following...."+"\n");
            BookRental.borrowerList();String bookName=book.getTitle();
            bookMap.remove(bookName);
            System.out.println("book is rented successfully....");

        }
    }

    public Book searchBook(String bookname ){

        if(!bookMap.containsKey(bookname))
        {
            System.out.println("the book is not in the store"+"\n");

        }
        else{
            Book book=bookMap.get(bookname);
            System.out.println("book is available"+book.toString());
            return book;
        }
        return null;
    }
    public void returnBook()
    {
        BookRental.printBorrowList();
        System.out.println("enter the no.of days to rent boook");
        int days=sc.nextInt();
        //LoanRate.setAmount(days);
        LoanRate.setOverDueRateAcademic(days);
        System.out.println("amount="+LoanRate.getAmount()+"overdue amount="+LoanRate.getOverDueRateAcademic());
        System.out.println("book is returned");
    }

}

