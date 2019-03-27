package jachs.commons.lang.arrayutils;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/****
 * 集合处理工具类有点鸡助跟JDK的java.util.Arrays差不多
 * 
 * @author zhanchaohan
 *
 */
public class Demo {
	@Test
	public void ArrayUtilsAddDemo() {
		// 简单添加
		ArrayUtils arrayUtils = new ArrayUtils();
		boolean[] boo1 = new boolean[] { true, true };
		boolean[] boo2 = arrayUtils.add(boo1, false);

		for (boolean b : boo2) {
			System.out.println(b);
		}
		// 添加到指定下标
		char[] ch = new char[5];
		ch[1] = 'a';
		char[] ch1 = arrayUtils.add(ch, 2, 'b');
		for (char c : ch1) {
			System.out.println(c);
		}
		// 添加全部
		String[] st = new String[] { "我", "是" };
		String[] st1 = new String[] { "中", "国" };
		String[] st2 = arrayUtils.addAll(st, st1);
		for (String string : st2) {
			System.out.println(string);
		}
	}

	@Test
	public void ArrayUtilscloneDemo() {
		ArrayUtils arrayUtils = new ArrayUtils();
	}
}
