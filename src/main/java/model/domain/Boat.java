package model.domain;

/**
* A class representing a boat.
*/
public class Boat {
    
  private String name;
  private Enum boatType;
  private float length;
  
  /**
  * Returns the name of the boat.
  */
  private String getName() {
    return this.name;
  }

  /**
  * Sets the name of the boat.
  */
  private void setName(String name) {
    this.name = name;
  }

  /**
  * Returns the boat type.
  */
  private Enum getBoatType() {
    return this.boatType;
  }

  /**
  * Sets the boat type.
  */
  private void setBoatType(Enum boatType) {
    this.boatType = boatType;
  }

  /**
  * Returns the lenght of the boat.
  */
  private float getLength() {
    return this.length;
  }

  /**
  * Sets the lenght of the boat.
  */
  private void setLength(float length) {
    this.length = length;
  }
}
