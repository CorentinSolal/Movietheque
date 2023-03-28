package com.eni.mmi.controller;

import com.eni.exception.MovieException;
import com.eni.bo.Genre;
import com.eni.bo.Movie;
import com.eni.bo.Participant;
import com.eni.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller("movieBean")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String showAllMovies(Model model, HttpSession session) {

        List<Movie> movies = movieService.getAllMovies();

        if (movies == null) {
            movies = new ArrayList<>();
        }
        model.addAttribute("movies", movies);

        Movie newMovie = new Movie();

        model.addAttribute("newMovie", newMovie);
        return "movies";
    }

    @GetMapping("/movie/detail/{id}")
    public String findMovie(@PathVariable long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie";
    }

    // Création d'un nouveau film
    @PostMapping("/movie/add")
    public String createMovie(@ModelAttribute("newMovie") Movie newMovie, Model model, HttpSession session) {
        // Test si un membre est connecté
        Object att = session.getAttribute("userSession");
        if (att != null) {
            System.out.println(newMovie);
            try {
                movieService.saveMovie(newMovie);
                return "redirect:/movies";
            } catch (MovieException e) {
                model.addAttribute("errors", e.getErrors());
                model.addAttribute("newMovie", newMovie);
                return "movies";
            }

        } else {
            return "redirect:/login";
        }
    }

    // Injection en session des listes représentant les participants et les genres
    @ModelAttribute("movieParticipants")
    public List<Participant> getAllParticipants() {
        return movieService.getParticipants();
    }

    @ModelAttribute("movieGenres")
    public List<Genre> getAllGenres() {
        return movieService.getGenres();
    }
}
