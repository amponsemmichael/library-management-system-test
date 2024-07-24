package com.amponsem.librarymanagementsystem.models;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationTest {

    @Test
    public void testConstructorAndGetters() {
        int id = 1;
        int bookId = 101;
        int memberId = 201;
        Date reservationDate = Date.valueOf("2024-07-01");
        int reservationStatusId = 1;

        Reservation reservation = new Reservation(id, bookId, memberId, reservationDate, reservationStatusId);

        assertEquals(id, reservation.getId());
        assertEquals(bookId, reservation.getBookId());
        assertEquals(memberId, reservation.getMemberId());
        assertEquals(reservationDate, reservation.getReservationDate());
        assertEquals(reservationStatusId, reservation.getReservationStatusId());
    }

    @Test
    public void testSetId() {
        Reservation reservation = new Reservation(1, 101, 201, Date.valueOf("2024-07-01"), 1);
        reservation.setId(2);

        assertEquals(2, reservation.getId());
    }

    @Test
    public void testSetBookId() {
        Reservation reservation = new Reservation(1, 101, 201, Date.valueOf("2024-07-01"), 1);
        reservation.setBookId(102);

        assertEquals(102, reservation.getBookId());
    }

    @Test
    public void testSetMemberId() {
        Reservation reservation = new Reservation(1, 101, 201, Date.valueOf("2024-07-01"), 1);
        reservation.setMemberId(202);

        assertEquals(202, reservation.getMemberId());
    }

    @Test
    public void testSetReservationDate() {
        Reservation reservation = new Reservation(1, 101, 201, Date.valueOf("2024-07-01"), 1);
        Date newDate = Date.valueOf("2024-08-01");
        reservation.setReservationDate(newDate);

        assertEquals(newDate, reservation.getReservationDate());
    }

    @Test
    public void testSetReservationStatusId() {
        Reservation reservation = new Reservation(1, 101, 201, Date.valueOf("2024-07-01"), 1);
        reservation.setReservationStatusId(2);

        assertEquals(2, reservation.getReservationStatusId());
    }
}
