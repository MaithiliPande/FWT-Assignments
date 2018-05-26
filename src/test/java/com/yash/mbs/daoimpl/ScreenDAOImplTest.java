package com.yash.mbs.daoimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.NullObjectException;

public class ScreenDAOImplTest {
	
	ScreenDAO screenDAO; 
	
	@Before
	public void setUp() {
		screenDAO = new ScreenDAOImpl();
	}

	@Test(expected=NullObjectException.class)
	public void insertScreen_IfScreenObjectNull_ShouldThrowNullObjectException() {
		screenDAO.insert(null);
	}
	
	@Test
	public void insertScreen_ScreenObjectGiven_shouldReturnTrue() {
		Screen screen = new Screen(1, "Screen1");
		boolean actualResult = screenDAO.insert(screen);
		assertEquals(true, actualResult);
	}
	
	@Test
	public void checkScreenListSize_IfScreenListIsNull_ShouldReturnZero() {
		assertEquals(0, screenDAO.getScreenListSize());
	}
	
	
	

}
