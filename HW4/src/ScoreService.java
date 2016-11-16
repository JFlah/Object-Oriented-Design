import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Jack on 9/29/2016.
 */
public class ScoreService {
    private String currentSport = null;
    private String currentHomeTeam = null;
    private String currentHomeScore = null;
    private String currentAwayTeam = null;
    private String currentAwayScore = null;

    private static Collection<Client> observers = new ArrayList<Client>();

    public ScoreService(ScoreInput input) {
        input.registerObserver(this);
    }

    public void registerObserver(Client obs) {
        observers.add(obs);
    }

    public void removeObserver(Client obs) {
        observers.remove(obs);
    }

    public void notifyObservers() {
        for (Client client : observers) {
            client.update(this);
        }
    }

    public void update(String sport, String homeTeam, String homeScore, String awayTeam, String awayScore) {
        this.currentSport = sport;
        this.currentHomeTeam = homeTeam;
        this.currentHomeScore = homeScore;
        this.currentAwayTeam = awayTeam;
        this.currentAwayScore = awayScore;
        notifyObservers();
    }

    public String getCurrentSport() {
        return currentSport;
    }

    public String getCurrentHomeTeam() {
        return currentHomeTeam;
    }

    public String getCurrentHomeScore() {
        return currentHomeScore;
    }

    public String getCurrentAwayTeam() {
        return currentAwayTeam;
    }

    public String getCurrentAwayScore() {
        return currentAwayScore;
    }
}
