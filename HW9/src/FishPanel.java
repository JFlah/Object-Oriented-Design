import java.awt.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public class FishPanel extends JPanel {
	private Collection<Fish> fishes = new ArrayList<Fish>();
	private boolean suspended = false;

	public FishPanel() {
		setBackground(Color.blue);
	}

	public void tick() {
		if (!suspended) {
			Dimension tanksize = getSize();
			for(Fish f : fishes)
				f.move(tanksize);
			repaint();
		}
	}

	public void toggleSuspend() {
		suspended = !suspended;
	}

	public void addFish(Fish f) {
		fishes.add(f);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Fish f : fishes) 
			f.display(this, g);
	}
}