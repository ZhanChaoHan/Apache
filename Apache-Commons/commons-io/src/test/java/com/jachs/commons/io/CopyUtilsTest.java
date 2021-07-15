package com.jachs.commons.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
@Deprecated
public class CopyUtilsTest {
	OutputStream output;

	@Test
	public void init() throws FileNotFoundException {
		output = new FileOutputStream(CopyUtilsTest.class.getResource("").getPath() + File.separator + "test.txt");
	}

	@Test
	public void test1() throws IOException {
	}
}
