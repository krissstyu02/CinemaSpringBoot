package com.example.cinemaspringboot;

public class AppInfo {
    private final int totalSessions;
    private final double averageTicketPrice;

    private final double averageDuration;

    // Add more fields as needed

    public AppInfo(int totalSessions, double averageTicketPrice,double averageDuration) {
        this.totalSessions = totalSessions;
        this.averageTicketPrice = averageTicketPrice;
        this.averageDuration = averageDuration;
    }

    public int getTotalSessions() {
        return totalSessions;
    }

    public double getAverageTicketPrice() {
        return averageTicketPrice;
    }

    public double getAverageDuration() {
        return averageDuration;
    }

}
