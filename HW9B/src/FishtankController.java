import java.awt.*;
import java.util.Collection;

/**
 * Created by Jack on 12/5/2016.
 */
public class FishtankController implements FTModelObserver, FTViewObserver {
    private FishtankView view;
    private FishtankModel model;

    public FishtankController(FishtankView view, FishtankModel model) {
        this.view = view;
        this.model = model;
        view.addObserver(this);
        model.addObserver(this);
    }

    public FishtankView getView() {
        return view;
    }

    public FishtankModel getModel() {
        return model;
    }


    // FishtankModelObserver methods

    @Override
    public void isSuspended(boolean b) {
        view.isSuspended(b);
    }

    @Override
    public void update(Collection<Fish> fishes) {
        view.update(fishes);
    }

    // FishtankViewObserver methods

    @Override
    public void newFish(String fishType) {
        model.newFish(fishType, view);
    }

    @Override
    public void startStopPressed() {
        model.startStopPressed();
    }

    @Override
    public void setSize(Dimension d) {
        model.setSize(d);
    }
}
