package com.TrimindTech.BookRental;

import java.util.ArrayList;
import java.util.List;

public class Borrower extends BarrowerFile {
    public ArrayList<BarrowerFile> borrowerFiles = new ArrayList<>();
    public void addBorrower(BarrowerFile borrowerFile) {
        borrowerFiles.add(borrowerFile);
        System.out.println("user details updated");
        System.out.println(borrowerFiles.toString());
    }
    public List<BarrowerFile> getAllBorrowerList() {
        return borrowerFiles;
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + firstName + '\'' +
                ", title='" + lastName + '\'' +
                ", ISBN=" + email +
                ", isAcademic=" + bookName +
                '}';
    }
}