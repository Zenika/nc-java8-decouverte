package mmm.part02_stream;

import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class GruTest {

    private Gru gru;

    private Collection<Minion> minions;

    // TODO les tests sont longs ? Et si on faisait tout en parallel ?
    @Before
    public void prepare() {
        minions = new ArrayList<>();
        for (int i = 0; i < 300_000; i++) {
            minions.add(new Carl());
            minions.add(new Dave());
            minions.add(new Kevin());
        }
        gru = new Gru(minions);
    }

    @Test
    public void shouldStealTheMoon() {
        gru.stealTheMoon();
        assertThat(gru.hasStealTheMoon()).isTrue();
        // Condition n'est pas une interface, on ne peut donc pas utiliser de lambda
        assertThat(minions).are(new Condition<Minion>("Minions should execute order") {
            @Override
            public boolean matches(Minion value) {
                return value.hasExecutedOrder();
            }
        });
    }

    @Test
    public void shouldCalculateAverageMinionsAge() {
        assertThat(gru.computeMinionsAverageAge()).isEqualTo(6);
    }

}
