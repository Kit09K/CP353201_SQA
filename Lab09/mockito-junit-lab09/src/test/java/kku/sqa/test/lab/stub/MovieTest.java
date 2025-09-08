package kku.sqa.test.lab.stub;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kku.sqa.lab.api.Service;
import kku.sqa.lab.model.MovieModel;
import kku.sqa.lab.service.Favorite;
import kku.sqa.test.lab.service.ServiceStub;

public class MovieTest {
	private Service movieService;
	private Favorite favoriteMovie;

	@BeforeEach
    void setUp() {
        movieService = new ServiceStub();
        favoriteMovie = new Favorite(movieService);
    }
	
	@Test
    void test_FavoriteMovie_withStub_horrorCategory() {
        List<MovieModel> movieList = favoriteMovie.getMovie("username", "horror");

        assertAll(
            () -> assertNotNull(movieList, "not null"),
            () -> assertEquals(5, movieList.size(), "horror 5")
        );
    }
}
