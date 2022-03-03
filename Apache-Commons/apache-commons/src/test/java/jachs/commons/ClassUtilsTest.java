package jachs.commons;

import java.util.List;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;


/****
 * 
 * @author zhanchaohan
 *
 */
public class ClassUtilsTest {
	ClassUtils cUtill=new ClassUtils();
	
	@Test
	public void test1() {
		
		//获取全部接口
		List<Class<?>> allInterface=cUtill.getAllInterfaces(TypeUtils.class);
		
		allInterface.forEach(a->{
			System.out.println(a.getName());
		});
	}
	@Test
	public void test2() {
		String packName=cUtill.getPackageName(TypeUtils.class);
		
		System.out.println(packName);
	}
	@Test
	public void test3() {
		String simpleName=cUtill.getSimpleName(TypeUtils.class, "sim");
		
		System.out.println(simpleName);
	}
}
