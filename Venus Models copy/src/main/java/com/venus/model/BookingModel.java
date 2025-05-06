package com.venus.model;

public class BookingModel {

    private int bookingId;
    private String name;
    private String date;
    private String time;

    // Default constructor
    public BookingModel() {}

    // Constructor with all fields
    public BookingModel(int bookingId, String name, String date, String time) {
        this.bookingId = bookingId;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    // Constructor without ID (e.g., for insertion)
    public BookingModel(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
