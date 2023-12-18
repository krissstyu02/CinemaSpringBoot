package com.example.cinemaspringboot;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.example.cinemaspringboot.Session;

public class SessionManager {
    private List<Session> sessions = new ArrayList<>();
    private static final String FILE_PATH = "sessions.json"; // Укажите путь к вашему файлу

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(int sessionId) {
        sessions.removeIf(session -> session.getId() == sessionId);
    }

    public Session getSessionById(int sessionId) {
        return sessions.stream().filter(session -> session.getId() == sessionId).findFirst().orElse(null);
    }

    public List<Session> getAllSessions() {
        sessions=loadFromFile();
        return sessions;
    }

    public void saveToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(FILE_PATH), sessions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Session> loadFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            sessions = objectMapper.readValue(new File(FILE_PATH), new TypeReference<List<Session>>() {
            });
            return sessions;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
