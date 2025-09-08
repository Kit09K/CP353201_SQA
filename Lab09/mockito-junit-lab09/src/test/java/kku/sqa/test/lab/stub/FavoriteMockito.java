package kku.sqa.test.lab.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kku.sqa.lab.api.Service;
import kku.sqa.lab.model.MovieModel;
import kku.sqa.lab.service.Favorite;

public class FavoriteMockito {

	@Test
	void test_FavoriteMovie_withMockito() {
		Service movieService = mock(Service.class);
		List<MovieModel> movieList = Arrays.asList(new MovieModel("The Notebook","datenight"),
				new MovieModel("The Notebook","datenight"),
				new MovieModel("50 First Dates","datenight"),
				new MovieModel("A Walk to Remember","datenight"),
				new MovieModel("First Love, The Lucky One","datenight"),
				new MovieModel("10 Things I Hate About You","datenight"),
				new MovieModel("The Conjuring","horror"),
				new MovieModel("Scream","horror"),
				new MovieModel("IT","horror"));
		
		when(movieService.getMoviesByUsername("username")).thenReturn(movieList);
		when(movieService.getMoviesByUsername("emptyUser")).thenReturn(Collections.emptyList());
		
		Favorite favoriteMovie = new Favorite(movieService);
		List<MovieModel> datenightMovieList = favoriteMovie.getMovie("username", "datenight");
		
		assertEquals(5, datenightMovieList.size());
		assertEquals("The Notebook", datenightMovieList.get(0).getTitle());
	}
}
