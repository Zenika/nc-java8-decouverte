package mmm.part04_correction;


public interface Minion {

    void takeOrder(Order order);

    boolean hasExecutedOrder();

    int getAge();

    default void seeBanana(){
        System.out.println("BA-NA-NAAAAA !!");
    }
}
