package com.yash.mbs.serviceimpl;

import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.IncorrectInputException;
import com.yash.mbs.exception.NullScreenObjectException;
import com.yash.mbs.exception.ScreenAlreadyExistsException;
import com.yash.mbs.exception.ScreenLimitExceedException;
import com.yash.mbs.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {
	
	ScreenDAO screenDAO;

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

	private void checkIfScreenExists(Screen screen) {
		if(screenDAO.getScreenName(screen)=="Screen1") {
			throw new ScreenAlreadyExistsException("This screen already exists");
		}
	}

	private void checkScreenListSize() {
		if(screenDAO.getScreenListSize()>3) {
			throw new ScreenLimitExceedException("Cannot add more than 3 screens");
		}
	}

	private void checkForCorrectInput(Screen screen) {
		if(screen.getId()<0 || screen.getName()==null) {
			throw new IncorrectInputException("Incorrect input given");
		}
	}

	private void checkIfScreenIsNull(Screen screen) {
		if(screen == null) {
			throw new NullScreenObjectException("Screen object is null");
		}
	}
	
	

}
