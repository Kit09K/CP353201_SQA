package kku.sqa.test.lab.service;

import kku.sqa.lab.api.Service;
import kku.sqa.lab.model.MovieModel;

import java.util.Arrays;
import java.util.List;

public class ServiceStub implements Service{
	
	public List<MovieModel> getMoviesByUsername(String username){
		return Arrays.asList(
				new MovieModel("The Notebook","datenight"),
				new MovieModel("50 First Dates","datenight"),
				new MovieModel("A Walk to Remember","datenight"),
				new MovieModel("First Love, The Lucky One","datenight"),
				new MovieModel("10 Things I Hate About You","datenight"),
				new MovieModel("The Conjuring","horror"),
				new MovieModel("Scream","horror"),
				new MovieModel("IT","horror")
				);
	}

}
