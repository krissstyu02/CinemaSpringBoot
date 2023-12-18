package com.example.cinemaspringboot.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.cinemaspringboot.Session;
import com.example.cinemaspringboot.SessionManager;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/sessions")
public class MovieSessionController {
    private final SessionManager sessionManager = new SessionManager();

    @PostMapping
    public void addSession(@RequestBody Session session) {
        sessionManager.addSession(session);
    }

    @DeleteMapping("/{id}")
    public void removeSession(@PathVariable int id) {
        sessionManager.removeSession(id);
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

}

