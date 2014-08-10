package mmm.part04_correction;


public class Carl implements Minion {

    private boolean orderExecuted = false;

    @Override
    public void takeOrder(Order order) {
        System.out.println("Carl a reçu un ordre");
        orderExecuted = true;
        order.doOrder();
    }

    public boolean hasExecutedOrder() {
        return orderExecuted;
    }

    @Override
    public int getAge() {
        return 3;
    }

}
