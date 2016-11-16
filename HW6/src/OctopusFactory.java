import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Jack on 10/26/2016.
 */
public class OctopusFactory extends FishFactory {
    @Override
    protected Fish create() {
        int randomXspeed = ThreadLocalRandom.current().nextInt(1, 10);
        int randomYspeed = ThreadLocalRandom.current().nextInt(1, 10);
        return new Octopus(new OscillatingMovement(randomXspeed, randomYspeed));
    }
}
