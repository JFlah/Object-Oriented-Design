/**
 * Created by Jack on 9/9/2016.
 */
public class Customer {

    private static final int CUST_ARRIVAL_PCT = 18;    // There is a 18% chance a customer arrives each second.

    private int arrivalTime;
    private int serviceTime;

    public Customer(int arrivalTime, int serviceTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public static boolean aCustomerArrives() {
        int n = (int) (Math.random() * 100);  // an integer between 0 and 99
        return n < CUST_ARRIVAL_PCT;
    }
}
