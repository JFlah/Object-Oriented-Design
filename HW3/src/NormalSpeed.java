/**
 * Created by Jack on 9/25/2016.
 */
public class NormalSpeed implements Cashier {
    private static final String WHO_NORMAL = "normal";

    public void elapseOneSecond(Customer currentCust) {
        currentCust.elapseOneSecond();
    }

    public String whoAmI() {
        return WHO_NORMAL;
    }
}
