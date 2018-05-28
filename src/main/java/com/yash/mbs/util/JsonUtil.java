package com.yash.mbs.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.NullObjectException;

public class JsonUtil {
	
	Logger logger = Logger.getLogger(JsonUtil.class);

	public String convertToJson(List<Screen> screenList) {
		if (screenList == null) {
			logger.error("screen list is null");
			throw new NullObjectException("Screen list is null");
		} else {
			Gson gson = new Gson();
			String screenJson = gson.toJson(screenList);
			logger.info("screen list converted to json object");
			return screenJson;
		}
	}

	public boolean writeToJsonFile(String screenJson) {
		boolean isfileWritten = false;
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("src/main/resources/screen.json");
			fileWriter.write(screenJson);
			logger.info("screen json object written to file");
			fileWriter.close();
			isfileWritten=true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isfileWritten;
	}

}
