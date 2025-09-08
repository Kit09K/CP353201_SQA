package kku.sqa.lab.api;
import java.util.List;

import kku.sqa.lab.model.MovieModel;

public interface Service {
	
	public List<MovieModel> getMoviesByUsername(String username);
}
