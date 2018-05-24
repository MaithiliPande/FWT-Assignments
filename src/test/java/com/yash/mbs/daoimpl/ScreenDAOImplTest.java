package com.yash.mbs.daoimpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.daoimpl.ScreenDAOImpl;
import com.yash.mbs.domain.Screen;

public class ScreenDAOImplTest {

	@Test
	public void insertScreen_ScreenObjectGiven_shouldReturnTrue() {
		ScreenDAO screenDAO = new ScreenDAOImpl();
		Screen screen = new Screen(1, "Screen1");
		boolean actualResult = screenDAO.insert(screen);
		assertEquals(true, actualResult);
	}
	

}
