public class OctopusFactory extends FishFactory {
	public Fish create() {
		MovementStyle ms = new HorizontalMovement(1);
		return new Octopus(ms);		
	}
}