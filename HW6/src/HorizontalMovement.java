/**
 * Created by Jack on 10/26/2016.
 */
public class HorizontalMovement extends MovementStyle {
    private int xspeed;
    private int xDirectionChangeFreq = 5;  // the fish changes horizontal direction 0.5% of the time

    public HorizontalMovement(int xspeed) {
        this.xspeed = xspeed;
    }

    @Override
    public int moveY(int pos, int fishheight, int tankheight) {
        return pos;
    }

    @Override
    public int moveX(int pos, int fishwidth, int tankwidth) {
        if (changesDirection(xDirectionChangeFreq) ||
                (pos + xspeed + fishwidth > tankwidth) ||
                (pos + xspeed < 0)) {
            xspeed = -xspeed;
            return pos;
        }
        else
            return pos + xspeed;
    }

    @Override
    public boolean movesRight() {
        return xspeed >= 0;
    }
}
