
public class Animal {
	private int numTeeth;
	private boolean spots;
	private int weight;
	
	public Animal(int numTeeth, boolean spots, int weight) {
		this.setNumTeeth(numTeeth);
		this.setSpots(spots);
		this.setWeight(weight);
	
	}
	public int getNumTeeth() {
		return this.numTeeth;
	}
	public boolean getSpots() {
		return this.spots;
	}
	public int getWeight() {
		return this.weight;
	}
	public void setNumTeeth(int numTeeth) {
		this.numTeeth = numTeeth;
	}
	public void setSpots(boolean spots) {
		this.spots = spots;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
	
