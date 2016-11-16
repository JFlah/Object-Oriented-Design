import javax.swing.ImageIcon;

public class AngelFish extends Fish {
	private ImageIcon leftimage, rightimage;

	public AngelFish(MovementStyle movementStyle) {
		super(movementStyle);
		leftimage  = new ImageIcon("./images/Langelfish.gif");
		rightimage = new ImageIcon("./images/Rangelfish.gif");
	}

	protected ImageIcon leftImage() {
		return leftimage;
	}

	protected ImageIcon rightImage() {
		return rightimage;
	}
}
