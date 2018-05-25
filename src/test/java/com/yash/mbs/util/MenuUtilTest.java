package com.yash.mbs.util;

import org.junit.Before;
import org.junit.Test;

import com.yash.mbs.exception.EmptyFileException;
import com.yash.mbs.exception.FileDoesNotExistException;

public class MenuUtilTest {
	
	MenuUtil menuUtil;
	@Before
	public void setUp() {
		menuUtil = new MenuUtil();
	}
	@Test(expected=FileDoesNotExistException.class)
	public void shouldThrowFileDoesNotExistExceptionWhenFileDoesNotExist() {
		menuUtil.findFile("testing.txt");
	}
	
	@Test(expected=EmptyFileException.class)
	public void shouldThrowEmptyFileExceptionWhenFileIsEmpty() {
		menuUtil.readFile("test.txt");
	}
	
	@Test
	public void testReadFileIfFileIsNotEmpty() {
		menuUtil.readFile("menu.txt");
	}

}
