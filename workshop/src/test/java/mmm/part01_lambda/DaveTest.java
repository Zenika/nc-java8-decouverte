package mmm.part01_lambda;

import org.junit.Test;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

public class DaveTest {

    @Test
    public void testDaveOrder() {
        Dave dave = new Dave();
        // AtomicBoolean est ici utilisé comme un wrapper afin d'avoir une référence final
        AtomicBoolean orderExecuted = new AtomicBoolean(false);
        // TODO use lambda
        dave.takeOrder(new Order() {
            @Override
            public void doOrder() {
                orderExecuted.set(true);
            }
        });
        assertThat(orderExecuted.get()).isTrue();
    }

    @Test
    public void shouldCountEachToysGivenToAgnes() throws IOException {
        Dave dave = new Dave();
        dave.giveAToyToAgnes(Toys.UNICORN);
        dave.giveAToyToAgnes(Toys.UNICORN);
        dave.giveAToyToAgnes(Toys.FART_GUN);
        dave.giveAToyToAgnes(Toys.UNICORN);
        int nbFartGun = dave.giveAToyToAgnes(Toys.FART_GUN);
        int nbBarbie = dave.giveAToyToAgnes(Toys.BARBIE);
        int nbUnicons = dave.giveAToyToAgnes(Toys.UNICORN);
        assertThat(nbUnicons).isEqualTo(4);
        assertThat(nbFartGun).isEqualTo(2);
        assertThat(nbBarbie).isEqualTo(1);
    }

    @Test
    public void shouldGiveAUnicornToAgnes() throws IOException {
        mmm.part02_stream.Dave dave = new mmm.part02_stream.Dave();
        ByteArrayOutputStream out = captureStdOut();
        int nbUnicons = dave.giveAToyToAgnes(mmm.part02_stream.Toys.UNICORN);
        assertThat(nbUnicons).isEqualTo(1);
        BufferedReader bufferedReader = getReaderForStdOut(out);
        assertThat(bufferedReader.readLine()).isEqualTo("It's so fluffy !");
    }

    private BufferedReader getReaderForStdOut(ByteArrayOutputStream out) {
        return new BufferedReader(
                new InputStreamReader(new ByteArrayInputStream(
                        out.toByteArray())));
    }

    private ByteArrayOutputStream captureStdOut() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }
}
