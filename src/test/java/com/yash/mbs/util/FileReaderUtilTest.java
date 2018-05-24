package com.yash.mbs.util;

import org.junit.Before;
import org.junit.Test;

import com.yash.mbs.exception.EmptyFileException;
import com.yash.mbs.exception.FileDoesNotExistException;

public class FileReaderUtilTest {
	
	FileReaderUtil fileReaderUtil;
	@Before
	public void setUp() {
		fileReaderUtil = new FileReaderUtil();
	}
	@Test(expected=FileDoesNotExistException.class)
	public void shouldThrowFileDoesNotExistExceptionWhenFileDoesNotExist() {
		fileReaderUtil.findFile("testing.txt");
	}
	
	@Test(expected=EmptyFileException.class)
	public void shouldThrowEmptyFileExceptionWhenFileIsEmpty() {
		fileReaderUtil.readFile("test.txt");
	}
	
	@Test
	public void testReadFileIfFileIsNotEmpty() {
		fileReaderUtil.readFile("menu.txt");
	}

}
