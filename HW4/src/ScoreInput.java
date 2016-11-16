import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Jack on 9/29/2016.
 */
public class ScoreInput {
    private static Collection<ScoreService> observers = new ArrayList<ScoreService>();

    public ScoreInput() {
        GUIFrame frame = new GUIFrame();
        frame.pack();
    }

    public void registerObserver(ScoreService obs) {
        observers.add(obs);
    }

    public void removeObserver(ScoreService obs) {
        observers.remove(obs);
    }

    public static void notifyObservers(GUIPanel panel) {
        String sport = panel.sportText.getText();
        String homeTeam = panel.homeText.getText();
        String homeScore = panel.homeScoreText.getText();
        String awayTeam = panel.awayText.getText();
        String awayScore = panel.awayScoreText.getText();

        for (ScoreService ss : observers) {
            ss.update(sport, homeTeam, homeScore, awayTeam, awayScore);
        }
    }
}

@SuppressWarnings("serial")
class GUIFrame extends JFrame {
    private static GUIPanel panel;

    public GUIFrame() {
        setTitle("Score Input");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(200, 200);
        panel = new GUIPanel();
        setContentPane(panel);
        setVisible(true);
    }

    public static void notifyObservable() {
        ScoreInput.notifyObservers(panel);
    }
}

@SuppressWarnings("serial")
class GUIPanel extends JPanel {
    private JLabel sportLabel = new JLabel("Sport");
    JTextField sportText = new JTextField("", 4);
    private JLabel homeLabel = new JLabel("Home team");
    JTextField homeText = new JTextField("", 4);
    private JLabel awayLabel = new JLabel("Away team");
    JTextField awayText = new JTextField("", 4);
    private JLabel homeScoreLabel = new JLabel("Home score");
    JTextField homeScoreText = new JTextField("", 4);
    private JLabel awayScoreLabel = new JLabel("Away score");
    JTextField awayScoreText = new JTextField("", 4);
    private JButton scoreButton = new JButton("NEW SCORE");

    public GUIPanel() {
        add(sportLabel);
        add(sportText);
        add(homeLabel);
        add(homeText);
        add(awayLabel);
        add(awayText);
        add(homeScoreLabel);
        add(homeScoreText);
        add(awayScoreLabel);
        add(awayScoreText);
        add(scoreButton);
        setLayout(new FlowLayout());
        scoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIFrame.notifyObservable();
            }
        });
    }
}
