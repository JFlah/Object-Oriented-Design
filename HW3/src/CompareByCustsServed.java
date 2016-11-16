import java.util.Comparator;

/**
 * Created by Jack on 9/26/2016.
 */
public class CompareByCustsServed implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        CashRegister c1 = (CashRegister) o1;
        int c1CustsServed = c1.customersServed();
        CashRegister c2 = (CashRegister) o2;
        int c2CustsServed = c2.customersServed();

        if (c1CustsServed > c2CustsServed) {
            return -1;
        }
        else if (c1CustsServed == c2CustsServed) {
            return 0;
        } else {
            return 1;
        }
    }
}
