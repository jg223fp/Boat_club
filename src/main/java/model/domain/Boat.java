package model.domain;

public class Boat {
    
  private String name;
  private Enum boatType;
  private float length;
  
  /**
  * Returns members name.
  */
  private String getName() {
    return this.name;
  }

  /**
  * @generated
  */
  private void setName(String name) {
    this.name = name;
  }

  /**
  * @generated
  */
  private Enum getBoatType() {
    return this.boatType;
  }
  /**
  * @generated
  */
  private void setBoatType(Enum boatType) {
    this.boatType = boatType;
  }

  /**
  * @generated
  */
  private float getLength() {
    return this.length;
  }

  /**
  * @generated
  */
  private void setLength(float length) {
    this.length = length;
  }
}
