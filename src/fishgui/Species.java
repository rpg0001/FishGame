package fishgui;

import java.util.Random;

public class Species {
	
	private String speciesName;
	private double maxWeight;
	private double minWeight;

	
	public Species(String name, double min, double max) {
		this.speciesName = name;
		this.maxWeight = max;
		this.minWeight = min;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public double getMinWeight() {
		return minWeight;
	}
	
	public double generateWeight() {
		double weight = 0.0;
		Random r = new Random(); 
		double num = r.nextDouble();
		double min = this.minWeight;
		double max = this.maxWeight;
		if (num <= 0.8) {
			//common
			weight = Math.floor(Math.random()*(max*0.3-min+1)+min);
		} else if (num > 0.8 && num <= 0.99) {
			//uncommon
			weight = Math.floor(Math.random()*(max*0.8-(max*0.4)+1)+max*0.4);
		} else if (num > 0.99) {
			//rare
			weight = Math.floor(Math.random()*(max-(max*0.8)+1)+max*0.8);
		}
		return weight;
	}
}
