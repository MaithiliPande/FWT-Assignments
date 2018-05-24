package com.yash.mbs.serviceimpl;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.yash.mbs.dao.MovieDAO;
import com.yash.mbs.exception.NullMovieObjectException;
import com.yash.mbs.service.MovieService;

public class MovieServiceImplTest {

	@Test(expected=NullMovieObjectException.class)
	public void addMovie_MovieObjectIsNull_ShouldThrowNullMovieObjectException() {
		MovieDAO movieDAO = mock(MovieDAO.class);
		MovieService movieService = new MovieServiceImpl(movieDAO);
		movieService.addMovieToScreen(null);
	}

}
