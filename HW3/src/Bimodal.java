import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Jack on 9/25/2016.
 */
public class Bimodal implements ItemDistribution {

    private int distSize;

    public Bimodal(int N) {
        distSize = N;
    }

    public int howManyItems() {
        if (ThreadLocalRandom.current().nextInt() % 2 == 0) {
            return ThreadLocalRandom.current().nextInt(1, distSize/4);
        } else {
            return ThreadLocalRandom.current().nextInt((3*distSize/4), distSize+1);
        }
    }
}
