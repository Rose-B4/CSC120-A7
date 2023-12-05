/**
 * A class for cafes, extends the building super class
 * Adds the ability for selling coffee and keeping track of what products are in stock
 */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * The constructor method for the cafe class. sets the following values, calls the super constructor from building, and prints flavor text to the console
     * @param name see the super class building
	 * @param address see the super class building
	 * @param nFloors see the super class building
     * @param nCoffeeOunces an int representing how much coffee is currently in stock
     * @param nSugarPackets an int representing how many packets of sugar are currently in stock
     * @param nCreams an int representing how many creamers are currently in stock
     * @param nCups an int representing how many cups are currently in stock
     */
    public Cafe(String name, String adress, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, adress, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    public Cafe(String name, String adress, int nFloors) {
        this(name, adress, nFloors, 0,0,0,0);
    }
    
    /**
     * A method to make a coffee for a customer
     * This method takes inputs for the order and removes the necessary items from the cafe's stock
     * @param size the number of coffee ounces that will be used to make the coffee
     * @param nSugarPackets the number of sugar packets that will be used
     * @param nCreams the number of creamers that will be used
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || nCups <1){
            // throw new RuntimeException("You dont have the ingredients required to make this drink");
            this.restock(20, 20, 20, 20);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Enjoy your coffee");
    }

    public void sellCoffee(int size) {
        if(this.nCoffeeOunces < size || nCups <1){
            this.restock(20, 0, 0, 20);
        }
        this.nCoffeeOunces -= size;
        this.nCups -= 1;
        System.out.println("Enjoy your coffee");
    }

    /**
     * A method to restock the cafe
     * This method takes inputs for how much of each item to restock, and then adds it all to the inventory
     * @param nCoffeeOunces an int for how much coffee will be added to the inventory
     * @param nSugarPackets an int for how many sugar packets will be added to the inventory
     * @param nCreams an int for how many creamers will be added to the inventory
     * @param nCups an int for how many cups will be added to the inventory
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Successfully restocked "+this.name);
    }

    public void showOptions(){
        super.showOptions();
        System.out.println("sellCoffee(size, nSugarPackets, nCreams)\n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)");
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe("","",1,1,1,1,1);
        cafe.restock(0, 0, 0, 0);

    }
}
