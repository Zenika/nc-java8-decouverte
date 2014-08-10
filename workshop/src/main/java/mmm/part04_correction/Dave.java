package mmm.part04_correction;

import java.util.HashMap;

public class Dave implements Minion {

    private final HashMap<Toys, Integer> toysCounter = new HashMap<>();

    private boolean orderExecuted = false;

    @Override
    public void takeOrder(Order order) {
        System.err.println("Poulet tikka massala ?");
        orderExecuted = true;
        order.doOrder();
    }

    public int giveAToyToAgnes(Toys toy) {
        takeOrder(() -> {
            if(toy == Toys.UNICORN) {
                System.out.println("It's so fluffy !");
            }
            toysCounter.compute(toy, (t, v) -> v == null ? 1 : v + 1);
        });
        return toysCounter.getOrDefault(toy, 0);
    }

    @Override
    public int getAge() {
        return 5;
    }

    public boolean hasExecutedOrder() {
        return orderExecuted;
    }
    
}
