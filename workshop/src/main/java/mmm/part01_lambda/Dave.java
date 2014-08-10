package mmm.part01_lambda;

import java.util.HashMap;

public class Dave implements Minion {

    private final HashMap<Toys, Integer> toysCounter = new HashMap<>();

    @Override
    public void takeOrder(Order order) {
        System.err.println("Poulet tikka massala ?");
        // TODO execute order for testDaveOrder
    }

    public int giveAToyToAgnes(Toys toy) {
        // TODO count given toys
        // TODO use lambda
        takeOrder(new Order() {
            @Override
            public void doOrder() {
            }
        });
        return toysCounter.getOrDefault(toy, 0);
    }

}
