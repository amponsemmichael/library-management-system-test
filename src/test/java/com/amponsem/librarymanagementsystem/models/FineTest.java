package com.amponsem.librarymanagementsystem.models;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FineTest {

    @Test
    public void testConstructorAndGetters() {
        int id = 1;
        int bookId = 101;
        int loanId = 202;
        Date fineDate = Date.valueOf("2024-07-22");
        int fineAmount = 50;

        Fine fine = new Fine(id, bookId, loanId, fineDate, fineAmount);

        assertEquals(id, fine.getId());
        assertEquals(bookId, fine.getBookId());
        assertEquals(loanId, fine.getLoanId());
        assertEquals(fineDate, fine.getFineDate());
        assertEquals(fineAmount, fine.getFineAmount());
    }

    @Test
    public void testSetId() {
        Fine fine = new Fine(1, 101, 202, Date.valueOf("2024-07-22"), 50);
        fine.setId(2);

        assertEquals(2, fine.getId());
    }

    @Test
    public void testSetBookId() {
        Fine fine = new Fine(1, 101, 202, Date.valueOf("2024-07-22"), 50);
        fine.setBookId(102);

        assertEquals(102, fine.getBookId());
    }

    @Test
    public void testSetLoanId() {
        Fine fine = new Fine(1, 101, 202, Date.valueOf("2024-07-22"), 50);
        fine.setLoanId(203);

        assertEquals(203, fine.getLoanId());
    }

    @Test
    public void testSetFineDate() {
        Fine fine = new Fine(1, 101, 202, Date.valueOf("2024-07-22"), 50);
        Date newDate = Date.valueOf("2024-08-01");
        fine.setFineDate(newDate);

        assertEquals(newDate, fine.getFineDate());
    }

    @Test
    public void testSetFineAmount() {
        Fine fine = new Fine(1, 101, 202, Date.valueOf("2024-07-22"), 50);
        fine.setFineAmount(100);

        assertEquals(100, fine.getFineAmount());
    }
}
