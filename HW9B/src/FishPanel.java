import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class FishPanel extends JPanel {
	private Collection<Fish> fishes = new ArrayList<>();

	public FishPanel() {
		setBackground(Color.blue);
	}

	public void doRepaint(Collection<Fish> fishes) {
		this.fishes = fishes;
		repaint();
	}

	public Dimension panelSize() {
		return getSize();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Fish f : fishes)
			f.display(this, g);
	}
}