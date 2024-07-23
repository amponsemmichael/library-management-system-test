package com.amponsem.librarymanagementsystem.models;

import java.sql.Date;

public class Fine {
    private int id;
    private int bookId;
    private int loanId;
    private Date fineDate;
    private int fineAmount;

    public Fine(int id, int bookId, int loanId, Date fineDate, int fineAmount) {
        this.id = id;
        this.bookId = bookId;
        this.loanId = loanId;
        this.fineDate = fineDate;
        this.fineAmount = fineAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public Date getFineDate() {
        return fineDate;
    }

    public void setFineDate(Date fineDate) {
        this.fineDate = fineDate;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }
}
