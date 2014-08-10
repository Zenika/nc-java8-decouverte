package mmm.part05_correction;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class DaveDateTest {

    @Test
    public void shouldGiveMonthDayAndYearOfBirth() throws IOException {
        Dave dave = new Dave();
        
        LocalDateTime birthDate = dave.getBirthDate();
        
        assertThat(birthDate.getMonthValue()).isEqualTo(11);
        assertThat(birthDate.getDayOfMonth()).isEqualTo(17);
        assertThat(birthDate.getYear()).isEqualTo(1984);
    }

    @Test
    public void shouldGiveDurationSecondsMinutesAndHours() throws IOException {
        Dave dave = new Dave();
        Carl carl = new Carl();

        Duration duration = Duration.between(dave.getBirthDate(), carl.getBirthDate());

        assertThat(duration.getSeconds()).isEqualTo(375321600L);
        assertThat(duration.toMinutes()).isEqualTo(6255360L);
        assertThat(duration.toHours()).isEqualTo(104256L);
    }

    @Test
    public void shouldGivePeriodYearsMonths() throws IOException {
        Dave dave = new Dave();
        Kevin kevin = new Kevin();

        Period period = Period.between(dave.getBirthDate().toLocalDate(), kevin.getBirthDate().toLocalDate());

        assertThat(period.getYears()).isEqualTo(29);
        assertThat(period.getMonths()).isEqualTo(11);
    }
    

    @Test
    public void shouldFormatDate() throws IOException {
        Dave dave = new Dave();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        assertThat(dateFormatter.format(dave.getBirthDate())).isEqualTo("1984-11-17");
    }
}
