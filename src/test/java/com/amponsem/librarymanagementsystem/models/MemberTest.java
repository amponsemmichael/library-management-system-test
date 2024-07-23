package com.amponsem.librarymanagementsystem.models;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberTest {

    @Test
    public void testConstructorAndGetters() {
        int id = 1;
        String firstName = "John";
        String lastName = "Doe";
        Date joinedDate = Date.valueOf("2024-01-01");
        int activeStatusId = 1;

        Member member = new Member(id, firstName, lastName, joinedDate, activeStatusId);

        assertEquals(id, member.getId());
        assertEquals(firstName, member.getFirstName());
        assertEquals(lastName, member.getLastName());
        assertEquals(joinedDate, member.getJoinedDate());
        assertEquals(activeStatusId, member.getActiveStatusId());
    }

    @Test
    public void testSetId() {
        Member member = new Member(1, "John", "Doe", Date.valueOf("2024-01-01"), 1);
        member.setId(2);

        assertEquals(2, member.getId());
    }

    @Test
    public void testSetFirstName() {
        Member member = new Member(1, "John", "Doe", Date.valueOf("2024-01-01"), 1);
        member.setFirstName("Jane");

        assertEquals("Jane", member.getFirstName());
    }

    @Test
    public void testSetLastName() {
        Member member = new Member(1, "John", "Doe", Date.valueOf("2024-01-01"), 1);
        member.setLastName("Smith");

        assertEquals("Smith", member.getLastName());
    }

    @Test
    public void testSetJoinedDate() {
        Member member = new Member(1, "John", "Doe", Date.valueOf("2024-01-01"), 1);
        Date newDate = Date.valueOf("2024-02-01");
        member.setJoinedDate(newDate);

        assertEquals(newDate, member.getJoinedDate());
    }

    @Test
    public void testSetActiveStatusId() {
        Member member = new Member(1, "John", "Doe", Date.valueOf("2024-01-01"), 1);
        member.setActiveStatusId(2);

        assertEquals(2, member.getActiveStatusId());
    }
}
