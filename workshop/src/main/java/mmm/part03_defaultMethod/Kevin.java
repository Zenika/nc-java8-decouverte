package mmm.part03_defaultMethod;

public class Kevin implements Minion {

    private boolean orderExecuted = false;

    @Override
    public void takeOrder(Order order) {
        System.out.println("Kevin a reçu un ordre");
        orderExecuted = true;
        order.doOrder();
    }

    public boolean hasExecutedOrder() {
        return orderExecuted;
    }

    @Override
    public int getAge() {
        return 10;
    }

    // TODO delete to get default implementation
    @Override
    public void seeBanana() {
    }
}
