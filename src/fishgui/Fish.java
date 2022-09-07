package fishgui;

public class Fish {
	
	private Species species;
	private double weight;
	
	public Fish(Species species, double weight) {
		this.species = species;
		if (weight == 0) {
			// for a new fish
			this.weight = this.species.generateWeight();
		} else {
			// for a saved fish
			this.weight = weight;
		}
		
	}

	public String getSpeciesName() {
		return species.getSpeciesName();
	}

	public double getWeight() {
		return weight;
	}
	
	public Species getSpecies() {
		return species;
	}
}
