package mmm.part04_correction;

import mmm.part04_correction.Carl;
import mmm.part04_correction.Dave;
import mmm.part04_correction.Gru;
import mmm.part04_correction.Kevin;
import mmm.part04_correction.Minion;

import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class GruTest {

    private Gru gru;

    private Collection<Minion> minions;

    @Before
    public void prepare() {
        minions = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
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
