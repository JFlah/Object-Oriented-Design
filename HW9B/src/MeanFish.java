import javax.swing.*;

public class MeanFish extends Fish {
	FishtankView view;

	public MeanFish(MovementStyle ms, FishtankView view) {
		setMovementStyle(ms);
		this.view = view;
	}

	public ImageIcon leftImage() {
		return view.getMeanFishLeft();
	}

	public ImageIcon rightImage() {
		return view.getMeanFishRight();
	}
}

