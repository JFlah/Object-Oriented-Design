public class MeanieFactory extends FishFactory {
	public Fish create(FishtankView view) {
		MovementStyle ms = new OscillatingMovement(8, 10);
		return new MeanFish(ms, view);
	}
}