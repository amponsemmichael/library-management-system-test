package com.amponsem.librarymanagementsystem.models;

import java.sql.Date;

public class Reservation {
    private int id;
    private int bookId;
    private int memberId;
    private Date reservationDate;
    private int reservationStatusId;

    public Reservation(int id, int bookId, int memberId, Date reservationDate, int reservationStatusId) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.reservationDate = reservationDate;
        this.reservationStatusId = reservationStatusId;
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

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getReservationStatusId() {
        return reservationStatusId;
    }

    public void setReservationStatusId(int reservationStatusId) {
        this.reservationStatusId = reservationStatusId;
    }
}
