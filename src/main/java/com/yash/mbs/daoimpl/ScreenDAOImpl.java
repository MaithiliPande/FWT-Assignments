package com.yash.mbs.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.NullObjectException;
import com.yash.mbs.util.JsonUtil;

public class ScreenDAOImpl implements ScreenDAO {

	Logger logger = Logger.getLogger(ScreenDAOImpl.class);
	List<Screen> screenList = new ArrayList<Screen>();

	public boolean insert(Screen screen) {
		if(screen == null) {
			logger.error("null screen provided");
			throw new NullObjectException("Screen object is null");
		}
		else {
			screenList.add(screen);
			logger.info("screen added to screen list");
			JsonUtil jsonUtil = new JsonUtil();
			String screenJson = jsonUtil.convertToJson(screenList);
			jsonUtil.writeToJsonFile(screenJson);
			return true;
		}
	}

	public int getScreenListSize() {
		return screenList.size();
	}

	public List<Screen> listScreens() {
		return screenList;
	}
	
	public Screen updateScreenList(Screen validScreenObject) {
		System.out.println(screenList);
		for (Screen screen : screenList) {
			if(validScreenObject.getName().equalsIgnoreCase(screen.getName())) {
				screenList.set(screenList.indexOf(screen), validScreenObject);
				JsonUtil jsonUtil = new JsonUtil();
				String screenJson = jsonUtil.convertToJson(screenList);
				jsonUtil.writeToJsonFile(screenJson);
				logger.info("screen list updated");
				break;
			}
		}
		return validScreenObject;
	}

	public Screen getScreenByName(String screenName) {
		for (Screen screen : screenList) {
			if(screenName.equalsIgnoreCase(screen.getName())) {
				return screen;
			}
		}
		return null;
	}

	
	

	

}
