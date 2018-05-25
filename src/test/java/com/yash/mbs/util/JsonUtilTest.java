package com.yash.mbs.util;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.NullObjectException;

public class JsonUtilTest {
	
	JsonUtil jsonUtil;
	
	@Before
	public void setUp() {
		jsonUtil = new JsonUtil();
	}

	@Test(expected=NullObjectException.class)
	public void convertObjectToJson_IfScreenListIsNull_ShouldThrowNullObjectException() {
		jsonUtil.convertToJson(null);
	}
	
	@Test
	public void testWriteToJsonFile() {
		Movie movie = new Movie(1, "Iron Man", "infinity productions", "RobertDowneyJr");
		Screen screen = new Screen(1, "Screen1", movie);
		
		List<Screen> screenList = Arrays.asList(screen);
		String screenJson = jsonUtil.convertToJson(screenList);
		jsonUtil.writeToJsonFile(screenJson);
	}

	
}
