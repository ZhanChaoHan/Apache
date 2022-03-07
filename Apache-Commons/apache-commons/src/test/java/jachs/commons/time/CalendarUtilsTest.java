package jachs.commons.time;

import java.util.Calendar;

import org.apache.commons.lang3.time.CalendarUtils;
import org.junit.Test;

/****
 * 
 * @author zhanchaohan
 *
 */
public class CalendarUtilsTest {
	CalendarUtils cu=new CalendarUtils(Calendar.getInstance());
	
	@Test
	public void test1() {
		int year=cu.getYear();
		int month=cu.getMonth()+1;
		int day=cu.getDayOfMonth();
		
		System.out.println(year+"-"+month+"-"+day);
	}
}
