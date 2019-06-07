package com.TrimindTech.BookRental;

public class BarrowerFile {
    //public static String firstName;
    public  String firstName;
    public  String lastName;
    public  String email;
    public String bookName;
    public static int noOfDaysLoan;
    public String date;

    public BarrowerFile() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
   // public static double overDueAmount;
    public String getFirstName() {
        return firstName;
    }

    public  void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public  void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public  void setEmail(String email) {
        this.email = email;
    }

    public int getNoOfDaysLoan() {
        return noOfDaysLoan;
    }

    public void setNoOfDaysLoan(int noOfDaysLoan) {
        this.noOfDaysLoan = noOfDaysLoan;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BarrowerFile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", bookName='" + bookName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
