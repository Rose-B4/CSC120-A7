/**
 * A class for libraries, extends the building super class
 * Adds the ability for having a collection of books that can be checked in and out
 */
import java.util.ArrayList;
import java.util.Hashtable;

public class Library extends Building {

	private Hashtable<String, Boolean> collection;

	/**
	 *
	 * The constructor method for the library class. sets the following values, calls the super constructor from building, and prints flavor text to the console
	 * @param name see the super class building
	 * @param address see the super class building
	 * @param nFloors see the super class building
	 */
	public Library(String name, String address, int nFloors) {
		super(name, address, nFloors);
		this.collection = new Hashtable<String, Boolean>();
		System.out.println("You have built a library: 📖");
	}

	/**
	 * A modifier for the library's collection
	 * The inputted book will be added to the collection and default to being in stock
	 * @param title the name of the book that will be added
	 */
	public void addTitle(String title) {
		this.collection.put(title, true);
	}

	/**
	 * A modifier for the library's collection
	 * The inputted book will be removed from the collection
	 * @param title the name of the book that will be removed
	 * @return returns the title of the book that was just removed
	 */
	public String removeTitle(String title) { // return the title that we removed
		if(!this.containsTitle(title)){
			throw new RuntimeException("This book is not in the collection");
		}
		this.collection.remove(title);
		return title;
	}

	/**
	 * A modifier for the library's collection
	 * The inputted book's status will be set to false if it is currently available
	 * @param title The book that will be checked out
	 */
	public void checkOut(String title) {
		if(!this.containsTitle(title)){
			throw new RuntimeException("This book is not in the collection");
		}
		if(this.collection.get(title) == false) {
			throw new RuntimeException(title +" is already checked out");
		}
		this.collection.replace(title, false);
	}

	/**
	 * A modifier for the library's collection
	 * The inputted book's status will be set to true if it is currently checked out
	 * @param title The book that will be checked out
	 */
	public void returnBook(String title) {
		if(!this.containsTitle(title)){
			throw new RuntimeException(title +" is not in the collection");
		}
		if(this.collection.get(title) == true) {
			throw new RuntimeException(title +" has already been returned");
		}
		this.collection.replace(title, true);
	}

	public void returnBook(String[] titles) {
		for(int i=0; i<titles.length; i++) {
			try{
				this.returnBook(titles[i]);
			} catch(RuntimeException e){
				System.out.println(e);
			}
		}
	}

	/**
	 * An accessor method for the library's collection
	 * This method checks if the inputted book is part of the library's collection
	 * This method does NOT check if the book is currently available, only if the book is part of the library's collection
	 * @param title the title of the book that will be looked for
	 * @return this method returns true if the book was found in the collection, and false if not
	 */
	public boolean containsTitle(String title) { // returns true if the title appears as a key in the Libary's collection, false otherwise
		if(this.collection.containsKey(title)){
			return true;
		}
		else { return false; }
	}

	/**
	 * An accessor method for the library's collection
	 * Checks if the inputted book is currently available from the library
	 * @param title The title of the book that will be checked
	 * @return this method returns true if the book is currently available and false if not
	 */
	public boolean isAvailable(String title) { // returns true if the title is currently available, false otherwise
		if(this.containsTitle(title)){
			throw new RuntimeException("This book is not in the collection");
		}
		return this.collection.get(title);
	}

	public boolean isAvailable() {
		boolean anyTitlesAvailable = false;
		ArrayList<String> collectionTitles = new ArrayList<>(collection.keySet());
		System.out.println("Here is the current available collection");
		for(int i = 0; i < collection.size(); i++){ 
			if(collection.get(collectionTitles.get(i))) {
				System.out.println("Title: "+collectionTitles.get(i));
				anyTitlesAvailable = true;
			}
		}
		return anyTitlesAvailable;
	}

	/**
	 * This method prints out the entire collection and status of each book to the console
	 */
	public void printCollection() { // prints out the entire collection in an easy-to-read way (including checkout status)
		ArrayList<String> collectionTitles = new ArrayList<>(collection.keySet());
		for(int i = 0; i < collection.size(); i++){ 
			System.out.println("Title: "+collectionTitles.get(i) + " || Available: " + collection.get(collectionTitles.get(i)));
		}
	}

	public void showOptions() {
		super.showOptions();
        System.out.println("addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + containsTitle(title) \n + isAvailable(title) \n + printCollection()");
    }

	public static void main(String[] args) {
		Library library = new Library("Public Library", "4 Super Street", 2);
		library.addTitle("hsdkfjhsd");
		library.addTitle("hfghfgh");
		library.addTitle("sdf erdg");
		library.addTitle("null");
		library.checkOut("null");
		// library.printCollection();
		library.removeTitle("hfghfgh");
		library.printCollection();
	}
  
  }