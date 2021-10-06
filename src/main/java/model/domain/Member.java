package model.domain;

import java.util.ArrayList;

/**
 * A class representing a member.
 */
public class Member extends Person {

  private Integer memberId;
  private ArrayList<Boat> boats;

  /**
   * Class constructor.
   */
  public Member(String firstName, String lastName, long personalNumber, int memberId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.personalNumber = personalNumber;
    this.memberId = memberId;
    this.boats = new ArrayList<Boat>();
  }

  /**
   * Returns member ID.
   */
  public Integer getMemberId() {
    return this.memberId;
  }

  /**
   * Sets the member ID.
   */
  public void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }

  /**
   * Returns an ArrayList of the members boats.
   */
  public Iterable<Boat> getBoatList() {
    return boats;
  }

  /**
   * Returns the number of boats owned by the member.
   */
  public Integer getNumberOfBoats() {
    return this.boats.size();
  }

  /**
   * Adds a boat object to a members boatlist.
   */
  public void addBoat(Boat b) {
    this.boats.add(b);
  }

  /**
   * Delete a boat object from a members boatlist.
   */
  public void deleteBoat(int index) {
    boats.remove(index - 1);
  }

  /**
   * Returns a boat object.
   */
  public Boat getBoat(int index) {
    return boats.get(index - 1);
  }
}
