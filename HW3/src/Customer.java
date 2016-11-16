public class Customer {
    private int arrivalTime;
    private int serviceTime;
    private ItemDistribution distType;

    public Customer(int t, ItemDistribution distType) {
        arrivalTime = t;
        this.distType = distType;
        int howManyItems = distType.howManyItems();
        serviceTime = 2 * howManyItems + 10;
    }

    public void elapseOneSecond() {
        serviceTime--;
    }

    public boolean isFinished() {
        return serviceTime == 0;
    }

    public int arrivalTime() {
        return arrivalTime;
    }
}