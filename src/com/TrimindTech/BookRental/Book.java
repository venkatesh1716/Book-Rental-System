package com.TrimindTech.BookRental;

public class Book {
    private String name;
    private String title;
    private int ISBN;
    public String isAcademic;
    private int totalCount;
    Book()
    {

    }
    Book(String name,String title,int ISBN,String isAcademic,int totalCount)
    {
        this.name=name;
        this.title=title;
        this.ISBN=ISBN;
        this.isAcademic=isAcademic;
        this.totalCount=totalCount;
    }

    public String isAcademic() {
        return isAcademic;
    }

    public String setAcademic(String academic) {
       return this.isAcademic = academic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", ISBN=" + ISBN +
                ", isAcademic=" + isAcademic +
                ", totalCount=" + totalCount +
                '}';
    }

}
