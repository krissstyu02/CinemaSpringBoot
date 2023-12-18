package com.example.cinemaspringboot.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.cinemaspringboot.Session;
import com.example.cinemaspringboot.SessionManager;
import com.example.cinemaspringboot.AppInfo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/sessions")
public class MovieSessionController {
    private final SessionManager sessionManager = new SessionManager();

    @PostMapping
    public void addSession(@RequestBody Session session) {
        loadFromFile();
        sessionManager.addSession(session);
        saveToFile();
    }

    @DeleteMapping("/{id}")
    public void removeSession(@PathVariable int id) {
        loadFromFile();
        sessionManager.removeSession(id);
        saveToFile();
    }

    @GetMapping("/{id}")
    public Session getSession(@PathVariable int id) {
        return sessionManager.getSessionById(id);
    }

    @GetMapping
    public List<Session> getAllSessions() {
        loadFromFile();
        return sessionManager.getAllSessions();
    }

    @PostMapping("/save")
    public void saveToFile() {
        sessionManager.saveToFile();
    }

    @PostMapping("/load")
    public  List<Session> loadFromFile() {
        return sessionManager.loadFromFile();
    }

    @GetMapping("/app-info")
    public AppInfo getAppInfo() {
        List<Session> allSessions = sessionManager.getAllSessions();
        int totalSessions = allSessions.size();
        double averageTicketPrice = calculateAverageTicketPrice(allSessions);
        double averageDuration = calculateAverageDuration(allSessions);
        AppInfo appInfo = new AppInfo(totalSessions, averageTicketPrice,averageDuration);
//        return ResponseEntity.ok(appInfo);
        return appInfo;
    }

    private double calculateAverageTicketPrice(List<Session> sessions) {
        if (sessions.isEmpty()) {
            return 0.0;
        }

        double totalTicketPrice = sessions.stream()
                .mapToDouble(Session::getTicketPrice)
                .sum();

        return totalTicketPrice / sessions.size();
    }

    private double calculateAverageDuration(List<Session> sessions) {
        if (sessions.isEmpty()) {
            return 0.0;
        }

        double totalDuration = sessions.stream()
                .mapToDouble(Session::getDuration)
                .sum();

        return totalDuration / sessions.size();
    }


}

