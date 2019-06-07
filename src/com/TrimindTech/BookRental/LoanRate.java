package com.TrimindTech.BookRental;

public class LoanRate extends Book {
    public  static  double overDueRateAcademic;
    public  static  double overDueRateNonAcademic;
    public static  double Amount;

    public static double getAmount() {
        return Amount;
    }

    public static  void setAmount(double amount) {
        Amount = amount;
    }

    public static double getOverDueRateAcademic() {
        return overDueRateAcademic;
    }

    public static void setOverDueRateAcademic(double overDueRateAcademic) {
        overDueRateAcademic = overDueRateAcademic;
    }

    public void setOverDueRateNonAcademic(double overDueRateNonAcademic) {
        this.overDueRateNonAcademic = overDueRateNonAcademic;
    }

    public double getOverDueRateNonAcademic() {
        return overDueRateNonAcademic;
    }
}

