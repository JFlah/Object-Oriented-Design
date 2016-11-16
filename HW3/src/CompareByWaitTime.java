import java.util.Comparator;

/**
 * Created by Jack on 9/26/2016.
 */
public class CompareByWaitTime implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        CashRegister c1 = (CashRegister) o1;
        int c1AvgWait = c1.avgWaitTime();
        CashRegister c2 = (CashRegister) o2;
        int c2AvgWait = c2.avgWaitTime();

        if (c1AvgWait > c2AvgWait) {
            return -1;
        }
        else if (c1AvgWait == c2AvgWait) {
            return 0;
        } else {
            return 1;
        }
    }
}
