package com.yash.mbs.serviceimpl;

import com.yash.mbs.dao.MovieDAO;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.exception.NullMovieObjectException;
import com.yash.mbs.service.MovieService;

public class MovieServiceImpl implements MovieService {
	
	MovieDAO movieDAO;

	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO=movieDAO;
	}

	public boolean addMovieToScreen(Movie movie) {
		if(movie == null) {
			throw new NullMovieObjectException("Movie object is null");
		}
		return false;
	}

}
