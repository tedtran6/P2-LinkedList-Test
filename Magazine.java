/*
 * Magazine: creates a class that implements IDedObject which allows us to create Magazine objects
 */

public class Magazine implements IDedObject {
	int magazineID;
	String magazineName;
	String publisherName;
	
	//constructor for the magazine
	public Magazine(int id, String magazineN, String publisherN) {
		magazineID = id;
		magazineName = magazineN;
		publisherName = publisherN;
	}
	
	//retrieves the ID of the magazine
	public int getID() {
		return magazineID;
	}
	
	//prints the magazine data
	public void printID() {
		System.out.println(magazineID + "\n" + magazineName + "\n" + publisherName);
	}
}
