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


}

