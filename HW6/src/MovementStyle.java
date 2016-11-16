/**
 * Created by Jack on 10/26/2016.
 */
public abstract class MovementStyle {
    protected boolean changesDirection(int frequency) {
        return Math.random() * 1000 < frequency;
    }

    protected abstract int moveX(int pos, int fishwidth, int tankwidth);
    protected abstract int moveY(int pos, int fishheight, int tankheight);
    protected abstract boolean movesRight();
}
