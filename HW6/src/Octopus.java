import javax.swing.ImageIcon;

public class Octopus extends Fish {
	private ImageIcon leftimage, rightimage;

	public Octopus(MovementStyle movementStyle) {
		super(movementStyle);
		leftimage  = new ImageIcon("./images/Loctopus.gif");
		rightimage = new ImageIcon("./images/Roctopus.gif");
	}

	protected ImageIcon leftImage() {
		return leftimage;
	}

	protected ImageIcon rightImage() {
		return rightimage;
	}
}

