package com.yash.mbs.dao;

import java.util.List;

import com.yash.mbs.domain.Screen;

public interface ScreenDAO {

	boolean insert(Screen screen);

	int getScreenListSize();

	List<Screen> listScreens();

	Screen updateScreenList(Screen validScreenObject);

	Screen getScreenByName(String string);
}
