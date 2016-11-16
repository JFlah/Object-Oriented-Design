import java.util.Arrays;
import java.util.Comparator;

public class DiningHall {
	private static final int CUST_ARRIVAL_PCT = 18;    // There is a 18% chance a customer arrives each second.

	private int totalRegisters;
	private CashRegister[] registers;
	private ItemDistribution distribution = null;
	private Comparator cmp = null;

	private String distType;

	public DiningHall(int normal, int fast, String distType, int distSize) {

		this.distType = distType;

		if (distType.equals("u")) {
			distribution = new Uniform(distSize);
		} else {
			distribution = new Bimodal(distSize);
		}

		// intiialize cashiers we need
		Cashier cashierFast = null;
		Cashier cashierNormal = null;
		if (normal > 0) {
			cashierNormal = new NormalSpeed();
		}
		if (fast > 0) {
			cashierFast = new Fast();
		}

		totalRegisters = normal + fast;
		registers = new CashRegister[totalRegisters];

		// populate registers list
		int index = 0;
		for (int i = 0; i < normal; i++, index++) {
			registers[index] = new CashRegister(cashierNormal, i);
		}
		for (int i = 0; i < fast; i++, index++) {
			registers[index] = new CashRegister(cashierFast, i);
		}
	}

	public void elapseOneSecond(int t) {
		if (aCustomerArrives()) {
			// The new customer goes into the smaller line.
			CashRegister chosenRegister = smallestLine();
			chosenRegister.addCustomer(t, distribution);
		}
		for (int r=0; r<totalRegisters; r++)
			registers[r].elapseOneSecond(t);  // Simulate each register for one second.
	}

	public void printStatistics(String sortType) {
		if (sortType.equals("w")){
			cmp = new CompareByWaitTime();
			Arrays.sort(registers, cmp);
		} else if (sortType.equals("s")) {
			cmp = new CompareByCustsServed();
			Arrays.sort(registers, cmp);
		} else {
			// nothing
		}

		for (int r=0; r<totalRegisters; r++) {
			CashRegister reg = registers[r];
			System.out.println("Register " + reg.whoAmI());
			System.out.println("\tNumber served = " + reg.customersServed());
			System.out.println("\tAverage wait time = " + reg.avgWaitTime());
		}
	}

	private boolean aCustomerArrives() {
		int n = (int) (Math.random() * 100);  // an integer between 0 and 99
		return n < CUST_ARRIVAL_PCT;
	}

	private CashRegister smallestLine() {
		CashRegister currentSmallest = registers[0];
		for (int r=1; r<totalRegisters; r++) {
			CashRegister cr = registers[r];
			if (cr.size() < currentSmallest.size())
				currentSmallest = cr;
		}
		return currentSmallest;	
	}
}
