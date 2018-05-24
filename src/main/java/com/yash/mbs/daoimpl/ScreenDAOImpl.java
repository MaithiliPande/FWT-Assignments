package com.yash.mbs.daoimpl;

import com.google.gson.Gson;
import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.Screen;

public class ScreenDAOImpl implements ScreenDAO {

	public boolean insert(Screen screen) {
			Gson gsonObj = new Gson();
			String screenObj = gsonObj.toJson(screen);
			System.out.println(screenObj);
			return true;
	}

	public String getScreenName(Screen screen) {
		return null;
	}

	public int getScreenListSize() {
		return 0;
	}

	

}
