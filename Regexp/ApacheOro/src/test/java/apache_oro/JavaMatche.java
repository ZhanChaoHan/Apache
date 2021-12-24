package apache_oro;

import java.util.regex.Pattern;

import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class JavaMatche {
	private void check(String text,String pattern) {
		boolean  matches = Pattern.matches(pattern, text);
		
		if(matches) {
			System.out.println("存在");
		}else {
			System.out.println("不存在");
		}
	}
	
	@Test
	public void test1() {
		check("tytufvbnhjk" + "kiegurf http://www.baidu.com",".*http://.*");
	}
	@Test
	public void test2() {
		check("2","\\d");//匹配一個數字
		check("2222","\\d+");//匹配多個數字
	}
	
}
