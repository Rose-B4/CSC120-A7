/**
 * A class for houses, extends the building super class
 * Adds the ability for people to move in and out as well as have a dining room
 */

import java.util.ArrayList;

public class House extends Building {

	private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
	private boolean hasDiningRoom;

	/**
	 * The constructor method for the house class. sets the following values, calls the super constructor from building, and prints flavor text to the console
	 * @param name see the super class building
	 * @param address see the super class building
	 * @param nFloors see the super class building
	 * @param hasDiningRoom a boolean that represents whether or not the house has a dining room
	 */
	public House(String name, String address, int nFloors, boolean hasDiningRoom) {
		super(name, address, nFloors);
		this.residents = new ArrayList<String>();
		this.hasDiningRoom = hasDiningRoom;
		System.out.println("You have built a house: 🏠");
	}

	/**
     * An accessor for whether or not the house has a dining room
     * @return returns the the state of the house's dining room
     */
	public boolean hasDiningRoom(){
		return this.hasDiningRoom;
	}

	/**
     * An accessor for the building's number of residents
     * @return returns the int of the building's residents, also known as the length of the residents list
     */
	public int nResidents(){
		return this.residents.size();
	}

	/**
	 * A modifier for the house's residents list
	 * @param name the name of the resident that will be added to the residents list
	 */
	public void moveIn(String name){
		this.residents.add(name);
	}

	public void moveIn(String[] names) {
		for(int i=0; i<names.length; i++) {
			this.moveIn(names[i]);
		}
	}

	/**
	 * A modifier for the house's residents list
	 * @param name the name of the resident that will be removed from the residents list
	 * @return returns the name of the resident that just moved out
	 */
	public String moveOut(String name){
		if(!this.residents.contains(name)){
			throw new RuntimeException(name+" doesn't live here and thus can't move out");
		}
		this.residents.remove(name);
		return name;
	}

	public String[] moveOut(String[] names){
		for(int i=0; i<names.length; i++) {
			try{
				this.moveOut(names[i]);
			} catch(RuntimeException e) {
				System.out.println(e);
			}
		}
		return names;
	}

	/**
     * An accessor for the building's residents list
	 * Checks for a single resident at a time
	 * @person the name of the person you are looking for in the residents list
     * @return returns true if the resident is in the house and false if not
     */
	public boolean isResident(String person){
		if(this.residents.contains(person)) { return true; }
		else { return false; }
	}

	public void showOptions() {
		super.showOptions();
        System.out.println("moveIn(name) \n + moveOut(name) \n + isResident(name)");
    }

	public static void main(String[] args) {
		House house = new House("Haven House", "110 Elm Street", 3, false);
		house.moveIn("null");
		house.moveIn("1null");
		house.moveIn("2null");
		house.moveIn("3null");
		house.moveIn("4null");
		house.moveIn("5null");
		house.moveIn("6null");

		house.moveOut(new String[]{"null", "1null", "2null"});
		System.out.println(house.isResident("null"));
		System.out.println(house.isResident("1null"));



	}

}