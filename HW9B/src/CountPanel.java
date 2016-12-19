import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jack on 12/6/2016.
 */
public class CountPanel extends JPanel implements ActionListener {
    JTextField countArea = new JTextField();
    boolean vis = true;
    public CountPanel() {
        JLabel label = new JLabel("The aquarium has ");
        countArea.setText("0");
        JLabel label2 = new JLabel("fish");
        this.add(label);
        this.add(countArea);
        this.add(label2);
    }

    public void incrementFishLabel() {
        int currentNum = Integer.parseInt(countArea.getText());
        countArea.setText(Integer.toString(++currentNum));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vis) {
            countArea.setVisible(false);
        } else {
            countArea.setVisible(true);
        }
        vis = !vis;
    }
}
