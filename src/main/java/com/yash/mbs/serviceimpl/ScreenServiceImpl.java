package com.yash.mbs.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.IncorrectInputException;
import com.yash.mbs.exception.NullObjectException;
import com.yash.mbs.exception.ScreenAlreadyExistsException;
import com.yash.mbs.exception.ScreenDoesNotExistException;
import com.yash.mbs.exception.ScreenLimitExceedException;
import com.yash.mbs.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {

	ScreenDAO screenDAO;
	Logger logger = Logger.getLogger(ScreenServiceImpl.class);

	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}
	
	public boolean addScreen(Screen screen) {
		checkIfScreenIsNull(screen);
		checkForCorrectInput(screen);
		checkScreenListSize();
		checkIfScreenExists(screen);
		return screenDAO.insert(screen);
	}

	public void checkIfScreenExists(Screen screen) {
		if (screenDAO.getScreenName(screen) == "Screen1") {
			logger.error("This screen already exists");
			throw new ScreenAlreadyExistsException("This screen already exists");
		}
	}

	private void checkScreenListSize() {
		if (screenDAO.getScreenListSize() > 3) {
			logger.error("screenlist size > 3");
			throw new ScreenLimitExceedException("Cannot add more than 3 screens");
		}
	}

	private void checkForCorrectInput(Screen screen) {
		if (screen.getId() < 0 || screen.getName() == null) {
			logger.error("input incorrect");
			throw new IncorrectInputException("Incorrect input given");
		}
	}

	private void checkIfScreenIsNull(Screen screen) {
		if (screen == null) {
			logger.error("null screen");
			throw new NullObjectException("Screen object is null");
		}
	}

	public boolean addMovieToScreen(String screenName, Movie movie) {
		if (movie == null) {
			logger.error("null movie");
			throw new NullObjectException("Movie object is null");
		}
		if ((movie.getId() < 0) || (movie.getTitle() == null) || (movie.getProduction() == null)
				|| (movie.getActor() == null) || (movie.getTitle() == "") || (movie.getProduction() == "")
				|| (movie.getActor() == "")) {
			logger.error("incorrect input provided");
			throw new IncorrectInputException("Incorrect input given");
		}
		Screen validScreenObject = checkScreenExistsInList(screenName);
		if (validScreenObject != null) {
			validScreenObject.setMovie(movie);
			Screen screen = screenDAO.updateScreenList(validScreenObject);
			screenDAO.insert(screen);
			logger.info("screen object updated");
		} else {
			throw new ScreenDoesNotExistException("Screen does not exist");
		}
		return false;
	}

	private Screen checkScreenExistsInList(String screenName) {
		List<Screen> screenList = screenDAO.listScreens();
		for (Screen screenObj : screenList) {
			if (screenName.equalsIgnoreCase(screenObj.getName())) {
				logger.info("screen object returned on basis of screenName");
				return screenObj;
			}
		}
		return null;
	}

}
