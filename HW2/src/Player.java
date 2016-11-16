import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Jack on 9/15/2016.
 */
public abstract class Player {
    private int chips = 0;
    private int rolls = 0;
    private String name;

    public static final int CHIPS_TO_WIN = 30;

    public static final String[] names = { "Moe", "Larry", "Curly", "Billy", "Bob", "John", "Paul", "Dennis" };

    public Player(int id) {
        String randomName = names[ThreadLocalRandom.current().nextInt(0, names.length)];
        this.name = randomName+id;
    }

    public int getRolls() {
        return rolls;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }


    public int getPot() {
        return HW2DiceGame.getChipPot();
    }

    public void increasePot(int increase) {
        HW2DiceGame.increaseChipPot(increase);
    }

    public void resetPot() {
        HW2DiceGame.resetChipPot();
    }

    public void printCounts() {
        HW2DiceGame.printChipCounts();
    }

    public int getAvgCount() {
        return HW2DiceGame.getAverageChipCount();
    }

    public int getNumberPlayers() {
        return HW2DiceGame.getPlayerListSize();
    }


    public int rollDie() {
        return ThreadLocalRandom.current().nextInt(1, 5);
    }

    public void takePotEndTurn() {
        setChips(getChips() + getPot());
        System.out.println(toString() + " stopped after " + rolls + " rolls" +
                " and won " + getPot() + " chips.\n");
        resetPot();
        rolls = 0;
    }

    public boolean rollForTurn() {
        rolls++;
        increasePot(rolls);
        for (int i = 0; i < rolls; i++) {
            if (rollDie() == 1) {
                aceOut();
                return false;
            }
        }
        return true;
    }

    private void aceOut() {
        System.out.println(toString() + " aced out after " + rolls + " rolls.\n");
        rolls = 0;
    }

    public abstract void doTurn();

    @Override
    public String toString() {
        return name;
    }
}
