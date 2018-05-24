package com.yash.mbs.dao;

import com.yash.mbs.domain.Screen;

public interface ScreenDAO {

	boolean insert(Screen screen);

	String getScreenName(Screen screen);

	int getScreenListSize();


}
