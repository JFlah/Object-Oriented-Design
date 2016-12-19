public class AngelFishFactory extends FishFactory {
	public Fish create(FishtankView view) {
		// each new fish has random speeds from 1 to 8
		int xspeed = 1 + (int)(8 * Math.random());
		int yspeed = 1 + (int)(8 * Math.random());
		MovementStyle ms = new UpDownMovement(xspeed, yspeed);
		return new AngelFish(ms, view);
	}
}
