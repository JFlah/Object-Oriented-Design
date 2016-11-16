/**
 * Created by Jack on 9/25/2016.
 */
public class Fast implements Cashier {
    private static final String WHO_FAST = "fast";

    public void elapseOneSecond(Customer currentCust) {
        currentCust.elapseOneSecond();
        if (currentCust.isFinished()) {
            return;
        }
        currentCust.elapseOneSecond();
    }

    public String whoAmI() {
        return WHO_FAST;
    }
}
