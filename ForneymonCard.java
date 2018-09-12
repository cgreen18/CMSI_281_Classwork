//package forneymonCardGame;

// ForneymonCard class
public class ForneymonCard {

	// declare instance variables
	private String type;
	private String name;

	// Default constructor for the ForneymonCard class
	ForneymonCard() {
		name = "MissingNu";
		type = "Burnymon";
	}


	ForneymonCard(String forneymonName, String forneymonType) {
		// checks that forneymonType is valid
		if (forneymonType.equals("Burnymon") || forneymonType.equals("Dampymon") || forneymonType.equals("Leafymon")) {
			name = forneymonName;
			type = forneymonType;
		} else {
			throw new IllegalArgumentException();
		}
		// checks that forneymonName isn't blank
		if (forneymonName.equals(null)) {
			throw new IllegalArgumentException();
		}

	}

	// toString() method
	public String toString() {
		return type + ": " + name;
	}

	// getters
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}



}
