package model.domain;

/**
* A class representing a boat.
*/
public class Boat {
  
  private enum BoatType {
    Sailboat, 
    Motorsailer, 
    Canoe, 
    Other
  }

  private String name;
  private float length;
  private BoatType type;
  
  /**
  * Returns the name of the boat.
  */
  public String getName() {
    return this.name;
  }

  /**
  * Sets the name of the boat.
  */
  public void setName(String name) {
    this.name = name;
  }

  /**
  * Returns the boat type.
  */
  public BoatType getBoatType() {
    return this.type;
  }

  /**
  * Sets the boat type.
  */
  public void setBoatType(BoatType type) {
    this.type = type;
  }

  /**
  * Returns the lenght of the boat.
  */
  public float getLength() {
    return this.length;
  }

  /**
  * Sets the lenght of the boat.
  */
  public void setLength(float length) {
    this.length = length;
  }
}
