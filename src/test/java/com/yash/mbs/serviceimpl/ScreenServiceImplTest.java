package com.yash.mbs.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.IncorrectInputException;
import com.yash.mbs.exception.NullScreenObjectException;
import com.yash.mbs.exception.ScreenAlreadyExistsException;
import com.yash.mbs.exception.ScreenLimitExceedException;
import com.yash.mbs.service.ScreenService;
import com.yash.mbs.serviceimpl.ScreenServiceImpl;

public class ScreenServiceImplTest {
	
	ScreenDAO screenDAO;
	ScreenService screenService;
	
	@Before
	public void setUp() {
		screenDAO = mock(ScreenDAO.class);
		screenService = new ScreenServiceImpl(screenDAO);
	}
	
	@Test(expected=NullScreenObjectException.class)
	public void addScreen_ScreenObjectEmpty_ShouldThrowNullScreenObjectException() {
		screenService.addScreen(null);
	}
	
	@Test(expected=IncorrectInputException.class)
	public void addScreen_ScreenIdIfLessThanZeroOrScreenNameIsNull_ShouldThrowIncorrectInputException() {
		screenService.addScreen(new Screen(-1, null));
	}

	@Test
	public void addScreen_ScreenObjectGiven_shouldReturnTrue() {
		Screen screen = new Screen(1,"Screen1");
		when(screenDAO.insert(screen)).thenReturn(true);
		boolean actualResult = screenService.addScreen(screen);
		assertEquals(true, actualResult);
	}

	@Test(expected=ScreenAlreadyExistsException.class)
	public void addScreen_ScreenNameIfSame_ShouldThrowScreenAlreadyExistsException() {
		Screen screen = new Screen(1, "Screen1");
		when(screenDAO.insert(screen)).thenReturn(true);
		when(screenDAO.getScreenName(screen)).thenReturn("Screen1");
		screenService.addScreen(screen);
	}
	
	@Test(expected=ScreenLimitExceedException.class)
	public void addScreen_NumberOfScreensIfMoreThanThree_ShouldThrowScreenLimitExceedException() {
		Screen screen = new Screen(1, "Screen1");
		when(screenDAO.insert(screen)).thenReturn(true);
		when(screenDAO.getScreenListSize()).thenReturn(4);
		screenService.addScreen(screen);
	}

}
