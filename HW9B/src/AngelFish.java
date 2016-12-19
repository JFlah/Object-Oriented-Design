import javax.swing.*;

public class AngelFish extends Fish {
	FishtankView view;

	public AngelFish(MovementStyle ms, FishtankView view) {
		setMovementStyle(ms);
		this.view = view;
	}

	public ImageIcon leftImage() {
		return view.getAngelFishLeft();
	}

	public ImageIcon rightImage() {
		return view.getAngelFishRight();
	}
}
