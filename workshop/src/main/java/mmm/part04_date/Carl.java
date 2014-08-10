package mmm.part04_date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
    
    @Override
    public Date getBirthDate() {
    	//TODO change using the new API-Date returning LocalDateTime
    	Calendar calendar = new GregorianCalendar();
    	
    	calendar.set(Calendar.YEAR, 1996);
    	calendar.set(Calendar.MONTH, 10); 
    	calendar.set(Calendar.DAY_OF_MONTH, 9); 
    	
    	return calendar.getTime();
    }

}
