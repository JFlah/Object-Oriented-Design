/**
 * Created by Jack on 10/26/2016.
 */
public class OscillatingMovement extends MovementStyle {
    private int xspeed;
    private int yspeed;
    private int xDirectionChangeFreq = 75;  // the fish changes horizontal direction 0.5% of the time
    private int yDirectionChangeFreq = 75; // the fish changes vertical direction 1% of the time

    public OscillatingMovement(int xspeed, int yspeed) {
        this.xspeed = xspeed;
        this.yspeed = yspeed;
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
    public int moveY(int pos, int fishheight, int tankheight) {
        if (changesDirection(yDirectionChangeFreq) ||
                (pos + yspeed + fishheight > tankheight) ||
                (pos + yspeed < 0)) {
            yspeed = -yspeed;
            return pos;
        }
        else
            return pos + yspeed;
    }

    @Override
    public boolean movesRight() {
        return xspeed >= 0;
    }
}
