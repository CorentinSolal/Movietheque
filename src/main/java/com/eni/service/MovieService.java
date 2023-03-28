package com.eni.service;

import com.eni.bo.Genre;
import com.eni.bo.Movie;
import com.eni.bo.Opinion;
import com.eni.bo.Participant;

import java.util.List;

public interface MovieService {
	List<Movie> getAllMovies();

	Movie getMovieById(long id);

	List<Genre> getGenres();

	Genre getGenreById(long id);

	List<Participant> getParticipants();

	Participant getParticipantById(long id);

	void saveMovie(Movie movie);
	

	// Pour gérer l'ajout et l'affichage des avis
	void saveOpinion(Opinion opinion, Movie selectedMovie);

	List<Opinion> getOpinionByMovie(long idMovie);
}
