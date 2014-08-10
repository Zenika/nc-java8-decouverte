package mmm.part04_date;

import java.util.Date;

public interface Minion {

    void takeOrder(Order order);

    boolean hasExecutedOrder();

    int getAge();

    default void seeBanana(){
        System.out.println("BA-NA-NAAAAA !!");
    }

    // TODO change it to LocalDateTime
	default Date getBirthDate() {
		return new Date();
	}
}
