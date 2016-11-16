import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 9/9/2016.
 */
public class CashRegister {

    private int customersServed = 0;
    private int totalWaitTime = 0;
    private List<Customer> customers = new ArrayList<Customer>();

    public CashRegister() {
    }

    public int getCustomersServed() {
        return customersServed;
    }

    public void incrementCustomersServed() {
        customersServed++;
    }

    public int getTotalWaitTime() {
        return totalWaitTime;
    }

    public void incrementTotalWaitTime(int increment) {
        totalWaitTime += increment;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public void elapseOneSecond(int currentTime) {
        // If the list is empty, there are no customers to process.
        List<Customer> customerList = getCustomers();
        if (customerList.size() == 0) {
            return;
        }

        // Otherwise, the first customer in line gets processed.
        Customer firstCustomer = customerList.get(0);
        int timeLeft = firstCustomer.getServiceTime()-1;

        if (timeLeft > 0) {
            firstCustomer.setServiceTime(timeLeft);
        }
        else { // We are done with this customer.
            // First update the register's statistics.
            incrementCustomersServed();
            int arrivalTime = firstCustomer.getArrivalTime();
            int waitTimeIncrement = currentTime - arrivalTime;
            incrementTotalWaitTime(waitTimeIncrement);

            // Then remove the customer.
            customerList.remove(firstCustomer);
        }
    }
}
