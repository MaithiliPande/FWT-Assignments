package com.yash.mbs.service;

import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;

public interface ScreenService {

	boolean addScreen(Screen screen);

	boolean addMovieToScreen(String name,Movie movie);


}
