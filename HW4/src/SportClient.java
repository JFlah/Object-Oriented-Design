import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jack on 9/29/2016.
 */
public class SportClient implements Client {
    private final String sport;

    public SportClient(String sport, ScoreService svc) {
        this.sport = sport;
        svc.registerObserver(this);
    }

    public void update(ScoreService svc) {
        String sport = svc.getCurrentSport();
        if (sport.equals(this.sport)) {
            SportGUIFrame frame = new SportGUIFrame(svc, this.sport);
            frame.pack();
        }
    }
}

@SuppressWarnings("serial")
class SportGUIFrame extends JFrame {
    private static SportGUIPanel panel;

    public SportGUIFrame(ScoreService svc, String sport) {
        setTitle(sport + " News");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(200, 200);
        setMinimumSize(new Dimension(300, 100));
        panel = new SportGUIPanel(svc);
        setContentPane(panel);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class SportGUIPanel extends JPanel {
    private JLabel newsLabel = new JLabel();
    private JButton okButton = new JButton("OK");

    public SportGUIPanel(ScoreService svc) {
        add(newsLabel);
        String homeTeam = svc.getCurrentHomeTeam();
        int homeScore = Integer.parseInt(svc.getCurrentHomeScore());
        String awayTeam = svc.getCurrentAwayTeam();
        int awayScore = Integer.parseInt(svc.getCurrentAwayScore());

        String winLossTie = (homeScore > awayScore) ? " defeats " : (homeScore < awayScore) ? " loses to " : " ties ";
        newsLabel.setText(homeTeam + winLossTie + awayTeam + ", " + homeScore + " to " + awayScore);

        add(okButton);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((JButton) e.getSource());
                frame.dispose();
            }
        });
    }
}

