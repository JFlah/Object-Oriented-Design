public class OctopusFactory extends FishFactory {
	public Fish create(FishtankView view) {
		MovementStyle ms = new HorizontalMovement(1);
		return new Octopus(ms, view);
	}
}