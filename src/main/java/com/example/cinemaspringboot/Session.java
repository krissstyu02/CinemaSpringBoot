package com.example.cinemaspringboot;

public class Session {
    private static int nextId = 1;

    private int id;
    private String movieName;
    private String startTime;
    private int duration; // Длительность фильма в минутах
    private double ticketPrice;

    public Session() {
    }

    public Session(String movieName, String startTime, int duration, double ticketPrice) {
        this.id = nextId++;
        this.movieName = movieName;
        this.startTime = startTime;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
    }

    public int getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}

