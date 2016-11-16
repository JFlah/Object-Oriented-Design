import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Jack on 9/25/2016.
 */
public class Uniform implements ItemDistribution {

    private int distSize;

    public Uniform(int N) {
        distSize = N;
    }

    public int howManyItems() {
        return ThreadLocalRandom.current().nextInt(1, distSize+1);
    }
}
