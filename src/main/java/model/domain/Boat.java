package model.domain;

/**
 * A class representing a boat.
 */
public class Boat {

  /**
   * Boat type enumeration.
   */
  public enum BoatType {
    Sailboat, Motorsailer, Canoe, Other, Count
  }

  private String name;
  private double length;
  private BoatType type;

  /**
   * Class constructor.
   */
  public Boat(String name, BoatType type, double lenght) {
    this.name = name;
    this.type = type;
    this.length = lenght;
  }

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
  public double getLength() {
    return this.length;
  }

  /**
   * Sets the lenght of the boat.
   */
  public void setLength(double length) {
    this.length = length;
  }
}
