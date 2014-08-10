package mmm.part05_correction;

import java.time.LocalDateTime;

public interface Minion {

    void takeOrder(Order order);

    boolean hasExecutedOrder();

    int getAge();

    default void seeBanana(){
        System.out.println("BA-NA-NAAAAA !!");
    }


	default LocalDateTime getBirthDate() {
		return LocalDateTime.now();
	}
}
