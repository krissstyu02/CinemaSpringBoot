package com.example.cinemaspringboot.Controller;
import com.example.cinemaspringboot.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.cinemaspringboot.SessionManager;
import com.example.cinemaspringboot.Controller.MovieSessionController;

import java.util.List;

@Controller
@RequestMapping("/sessions-page")
public class ViewController {
    private final SessionManager sessionManager = new SessionManager();
    private final MovieSessionController movieSessionController;

    public ViewController(MovieSessionController movieSessionController) {
        this.movieSessionController = movieSessionController;
    }
    @GetMapping
    public String showSessionsPage(Model model) {
//        List<Session> sessions2=MovieSessionController.loadFromFile();
//        movieSessionController.loadFromFile();  // Вызовите метод из MovieSessionController
//        List<Session> sessions = movieSessionController.getAllSessions();
        List<Session> sessions = sessionManager.getAllSessions();
        model.addAttribute("sessions", sessions);
        System.out.println("Number of sessions: " + sessions.size());
        return "index";
    }
}
