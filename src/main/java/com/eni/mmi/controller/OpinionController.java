package com.eni.mmi.controller;

import com.eni.bo.Member;
import com.eni.bo.Opinion;
import com.eni.exception.MovieException;
import com.eni.bo.Movie;
import com.eni.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/opinions")
public class OpinionController {
    private MovieService movieService;

    @Autowired
    public OpinionController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Création d'un nouvel avis
    @GetMapping("/add/{id}")
    public String createOpinion(@PathVariable(value = "id") long idMovie, Model model, HttpSession session) {
        // Test si un membre est connecté
        Object att = session.getAttribute("userSession");
        if (att != null) {
            //Mise en session du film sélectionné
            session.setAttribute("selectedMovie", movieService.getMovieById(idMovie));
            Opinion opinion = new Opinion();
            // Ajout de l'instance dans le modèle
            model.addAttribute("opinion", opinion);

            return "opinion";
        } else {
            return "redirect:/login";
        }
    }

    // Récupération de l'objet opinion du formulaire
    // sauvegarde
    @PostMapping("/add")
    public String createOpinion(@ModelAttribute("opinion") Opinion opinion, Model model, HttpSession session) {
        // Test si un membre est connecté
        Object att = session.getAttribute("userSession");
        if (att != null) {
            try {
                //Associé le membre à l'avis
                Member m = (Member) att;
                opinion.setMember(m);
                System.out.println(opinion);
                //Récupération du film en session :
                Movie selectedMovie = (Movie) session.getAttribute("selectedMovie");
                movieService.saveOpinion(opinion, selectedMovie);
                return "redirect:/movies";
            } catch (MovieException e) {
                model.addAttribute("errors", e.getErrors());
                return "opinion";
            }
        } else {
            return "redirect:/login";
        }
    }
}
