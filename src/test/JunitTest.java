package test;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;


/**
 * @author fengzhuo
 * @create 2020-08-16 23:13
 */
public class JunitTest {

    @Test
    public void testSimpleDateFormat() throws ParseException {
        String date = "2020-09-01";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = dateFormat.parse(date);
        System.out.println(parse.getTime());
    }
    
    @Test
    public void testCalendar(){
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        instance.set(Calendar.DAY_OF_MONTH,1);
        System.out.println(instance.getTime());
        instance.add(Calendar.HOUR,2);
        System.out.println(instance.getTime());
    }
    
}