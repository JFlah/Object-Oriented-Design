import javax.swing.*;

public class Octopus extends Fish {
	FishtankView view;

	public Octopus(MovementStyle ms, FishtankView view) {
		setMovementStyle(ms);
		this.view = view;
	}

	public ImageIcon leftImage() {
		return view.getOctopusLeft();
	}

	public ImageIcon rightImage() {
		return view.getOctopusRight();
	}
}
