public class MeanieFactory extends FishFactory {
	public Fish create() {
		MovementStyle ms = new OscillatingMovement(8, 10);
		return new MeanFish(ms);		
	}
}