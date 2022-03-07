package com.jachs.commons.lang;

import org.apache.commons.lang3.RegExUtils;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class RegExUtilsTest {
	//删除
	@Test
	public void test1() {
		System.out.println(RegExUtils.removeAll("文字547KMCN156.:_*&98", "\\d"));//删掉所有数字
		System.out.println(RegExUtils.removeAll("文字547KMCN156.:_*&98", "\\D"));//删掉所有文字
	}
	//替换
	@Test
	public void test2() {
		System.out.println(RegExUtils.replaceAll("aNaBa就是a,", "a", "A"));
	}
}
