
/**
 * Created by Jack on 9/9/2016.
 */
public class BetterDiningHallSimulation {
    private static final int SIMULATION_TIME = 50000;  // A simulation is for 50,000 seconds.
    private static final int NUM_REGISTERS = 4;        // There are 4 cash registers.

    // create registers
    private static CashRegister[] registers = new CashRegister[NUM_REGISTERS];

    public static void main(String[] args) {
        // First, initialize the cash register array.
        for (int r=0; r<NUM_REGISTERS; r++) {
            registers[r] = new CashRegister();
        }

        // Then perform the simulation for the specified number of seconds.
        for (int t=0; t<SIMULATION_TIME; t++) {
            if (Customer.aCustomerArrives()) {
                // The new customer goes into the smaller line.
                CashRegister chosenRegister = smallestRegister();
                int customerServeTime = calculateCustomerServeTime();
                Customer cust = new Customer(t, customerServeTime);
                chosenRegister.addCustomer(cust);
            }

            for (int r=0; r<NUM_REGISTERS; r++) {
                CashRegister currentReg = registers[r];
                currentReg.elapseOneSecond(t);  // Simulate each register for one second.
            }
        }

        // Print out the statistics.
        for (int r=0; r<NUM_REGISTERS; r++) {
            CashRegister reg = registers[r];
            int customersServed = reg.getCustomersServed();
            System.out.println("Register " + r);
            System.out.println("\tNumber of arrivals = " + customersServed);
            System.out.println("\tAverage wait time = " + (reg.getTotalWaitTime() / customersServed));
        }
    }

    private static int calculateCustomerServeTime() {
        return 2 * howManyItems() + 10;
    }

    private static int howManyItems() {
        int n = (int) (Math.random() * 10);
        return n + 1;
    }

    private static CashRegister smallestRegister() {
        CashRegister currentSmallest = registers[0];
        for (int r=1; r<NUM_REGISTERS; r++) {
            CashRegister reg = registers[r];
            if (reg.getCustomers().size() < currentSmallest.getCustomers().size()) {
                currentSmallest = reg;
            }
        }
        return currentSmallest;
    }
}
