import java.util.InputMismatchException;

/**
 * Created by Jack on 10/26/2016.
 */
public abstract class FishFactory {
    public static FishFactory getFactory(String fishName) {
        switch (fishName){
            case "Angel Fish":
                return new AngelFishFactory();
            case "Octopus":
                return new OctopusFactory();
            case "Mean Fish":
                return new MeanFishFactory();
            default:
                throw new InputMismatchException("Choose Angel Fish/Octopus/Mean Fish type");
        }
    }

    protected abstract Fish create();
}
