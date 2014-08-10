package mmm.part02_stream;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class Gru {

    private final Collection<Minion> minions;

    private final AtomicInteger minionsTryingToStealTheMoon = new AtomicInteger(0);

    public Gru(Collection<Minion> minions) {
        this.minions = minions;
    }

    public void stealTheMoon() {
        // TODO give order to all minions. The order will increment the minionsTryingToStealTheMoon counter
    }

    public double computeMinionsAverageAge() {
        // TODO calculate age average using the stream API
        return 0;
    }

    public boolean hasStealTheMoon() {
        return minionsTryingToStealTheMoon.get() == minions.size();
    }

}
