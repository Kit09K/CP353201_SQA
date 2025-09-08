package kku.sqa.lab.service;

import kku.sqa.lab.api.Service;
import kku.sqa.lab.model.MovieModel;

import java.util.List;
import java.util.stream.Collectors;

public class Favorite {

	private Service movieService;
	
	public Favorite(Service movieService) {
		super();
		this.movieService = movieService;
	}
	
	public List<MovieModel> getMovie(String username, String playlist) {
		List<MovieModel> allMovies = movieService.getMoviesByUsername(username);
		return allMovies.stream().filter(movie -> movie.getPlaylist().equalsIgnoreCase(playlist)).collect(Collectors.toList());
	}
}
