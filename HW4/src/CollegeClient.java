import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jack on 9/29/2016.
 */
public class CollegeClient implements Client {
    private final String college;

    public CollegeClient(String college, ScoreService svc) {
        this.college = college;
        svc.registerObserver(this);
    }

    public void update(ScoreService svc) {
        String awayTeam = svc.getCurrentAwayTeam();
        String homeTeam = svc.getCurrentHomeTeam();
        if (awayTeam.equals(college) || homeTeam.equals(college)) {
            CollegeGUIFrame frame = new CollegeGUIFrame(svc, college);
            frame.pack();
        }
    }
}

@SuppressWarnings("serial")
class CollegeGUIFrame extends JFrame {
    private static CollegeGUIPanel panel;

    public CollegeGUIFrame(ScoreService svc, String college) {
        setTitle(college + " News");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(200, 200);
        setMinimumSize(new Dimension(300, 100));
        panel = new CollegeGUIPanel(svc, college);
        setContentPane(panel);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class CollegeGUIPanel extends JPanel {
    private JLabel newsLabel = new JLabel();
    private JButton okButton = new JButton("OK");

    public CollegeGUIPanel(ScoreService svc, String college) {
        add(newsLabel);
        String sport = svc.getCurrentSport();
        String homeTeam = svc.getCurrentHomeTeam();
        int homeScore = Integer.parseInt(svc.getCurrentHomeScore());
        String awayTeam = svc.getCurrentAwayTeam();
        int awayScore = Integer.parseInt(svc.getCurrentAwayScore());

        String winLossTie;

        if (college.equals(homeTeam)) {
            winLossTie = (homeScore > awayScore) ? " defeated " : (homeScore < awayScore) ? " lost to " : " tied ";
            newsLabel.setText("The " + sport + " team" + winLossTie + awayTeam
                    + ", " + homeScore + " to " + awayScore);
        } else {
            winLossTie = (homeScore < awayScore) ? " defeated " : (homeScore > awayScore) ? " lost to " : " tied ";
            newsLabel.setText("The " + sport + " team" + winLossTie + homeTeam
                    + ", " + awayScore + " to " + homeScore);
        }

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
