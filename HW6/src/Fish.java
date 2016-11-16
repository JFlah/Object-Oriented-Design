import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public abstract class Fish {
	private Point currentpos;
	private MovementStyle movementStyle;

	public Fish(MovementStyle movementStyle) {
		this.movementStyle = movementStyle;
		int randomStartX = ThreadLocalRandom.current().nextInt(0, FishFrame.TANK_WIDTH/2);
		int randomStartY = ThreadLocalRandom.current().nextInt(0, FishFrame.TANK_HEIGHT/2);
		currentpos = new Point(randomStartX, randomStartY);
	}

	public void move(Dimension tanksize) {
		ImageIcon image = getImage();
		int x = movementStyle.moveX(currentpos.x, image.getIconWidth(),  tanksize.width);
		int y = movementStyle.moveY(currentpos.y, image.getIconHeight(), tanksize.height);
		currentpos = new Point(x,y);
	}
	
	public void display(JComponent c, Graphics g) {
      ImageIcon img = getImage();
      img.paintIcon(c, g, currentpos.x, currentpos.y);
   }
	
	private ImageIcon getImage() {
		if (movementStyle.movesRight())
			return rightImage();
		else
			return leftImage();
	}
	
	protected abstract ImageIcon rightImage();
	protected abstract ImageIcon leftImage();
}
