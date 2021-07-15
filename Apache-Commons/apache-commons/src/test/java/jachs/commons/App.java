package jachs.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class App {
    public static void main ( String[] args ) {
        System.out.println ( "相差日期为：" + App.daysxiangcha ( "2010-10-20", "2010-12-20" ) );
    }

    public static int daysxiangcha ( String dateStr1 , String dateStr2 ) {
        SimpleDateFormat sdf = new SimpleDateFormat ( "yyyyMMdd" );
        SimpleDateFormat sdf2 = new SimpleDateFormat ( "yyyy-MM-dd" );
        try {
            dateStr1 = sdf.format ( sdf2.parse ( dateStr1 ) );
            dateStr2 = sdf.format ( sdf2.parse ( dateStr2 ) );
        }
        catch ( ParseException e ) {
            e.printStackTrace ();
        }
        int year1 = Integer.parseInt ( dateStr1.substring ( 0, 4 ) );
        int month1 = Integer.parseInt ( dateStr1.substring ( 4, 6 ) );
        int day1 = Integer.parseInt ( dateStr1.substring ( 6, 8 ) );
        int year2 = Integer.parseInt ( dateStr2.substring ( 0, 4 ) );
        int month2 = Integer.parseInt ( dateStr2.substring ( 4, 6 ) );
        int day2 = Integer.parseInt ( dateStr2.substring ( 6, 8 ) );
        Calendar c1 = Calendar.getInstance ();
        c1.set ( Calendar.YEAR, year1 );
        c1.set ( Calendar.MONTH, month1 - 1 );
        c1.set ( Calendar.DAY_OF_MONTH, day1 );
        Calendar c2 = Calendar.getInstance ();
        c2.set ( Calendar.YEAR, year2 );
        c2.set ( Calendar.MONTH, month2 - 1 );
        c2.set ( Calendar.DAY_OF_MONTH, day2 );
        long mills = c1.getTimeInMillis () > c2.getTimeInMillis () ? c1.getTimeInMillis () - c2.getTimeInMillis ()
                : c2.getTimeInMillis () - c1.getTimeInMillis ();
        return (int) ( mills / 1000 / 3600 / 24 );
    }
}
