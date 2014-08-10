package mmm.part04_date;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class DaveDateTest {

    @Test
    public void shouldGiveMonthDayAndYearOfBirth() throws IOException {
        Dave dave = new Dave();
        
        Date birthDate = dave.getBirthDate();
        
        //TODO change it using java.time.LocalDateTime
        Calendar cal = Calendar.getInstance();
        cal.setTime(birthDate);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
        
        assertThat(month).isEqualTo(11);
        assertThat(day).isEqualTo(17);
        assertThat(year).isEqualTo(1984);
    }

    @Test
    public void shouldGiveDurationSecondsMinutesAndHours() throws IOException {
        Dave dave = new Dave();
        Carl carl = new Carl();
        
        //TODO use Duration on the new API Date Time instead 
        long duration  = dave.getBirthDate().getTime() - carl.getBirthDate().getTime();

        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);

        assertThat(diffInSeconds).isEqualTo(-375408000L);
        assertThat(diffInMinutes).isEqualTo(-6256800L);
        assertThat(diffInHours).isEqualTo(-104280L);
    }

    @Test
    public void shouldGivePeriodYearsMonths() throws IOException {
        Dave dave = new Dave();
        Kevin kevin = new Kevin();
        
        //TODO use Period on the new API Date Time instead 
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(dave.getBirthDate());
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(kevin.getBirthDate());

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

        assertThat(diffYear).isEqualTo(30);
        assertThat(diffMonth).isEqualTo(-1);
    }
    

    @Test
    public void shouldFormatDate() throws IOException {
        Dave dave = new Dave();

        // TODO use DateTimeFormatter instead
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        assertThat(dateFormatter.format(dave.getBirthDate())).isEqualTo("1984-12-17");
    }
}
