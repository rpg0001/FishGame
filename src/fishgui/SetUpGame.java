package fishgui;

import java.util.ArrayList;

public class SetUpGame {
	
	private ArrayList<Species> speciesList;
	
	public SetUpGame() {
		// note - currently cannot have spaces in species names - update bag methods to fix
		Species carp = new Species("carp", 2, 40);
		Species salmon = new Species("salmon", 3, 50);
		Species trout = new Species("trout", 1, 30);
		Species pike = new Species("pike", 1, 25);
		Species perch = new Species("perch", 1, 2);
		Species walleye = new Species("walleye", 1, 9);
		Species muskie = new Species("muskie", 6, 30);
		Species catfish = new Species("catfish", 1, 100);
		Species bluegill = new Species("bluegill", 1, 2);
		
		this.speciesList = new ArrayList<Species>();
		speciesList.add(carp);
		speciesList.add(salmon);
		speciesList.add(trout);
		speciesList.add(pike);
		speciesList.add(perch);
		speciesList.add(walleye);
		speciesList.add(muskie);
		speciesList.add(catfish);
		speciesList.add(bluegill);
		
	}
	
	public Fish generateFish() {
		Species randomSpecies = speciesList.get((int)Math.floor(Math.random()*(speciesList.size())));
		Fish fish = new Fish(randomSpecies, 0);
		return fish;
	}

	public ArrayList<Species> getSpeciesList() {
		return speciesList;
	}
	

	

}
