package model.domain;

import java.util.ArrayList;

/**
* A class representing a member.
*/
public class Member extends Person {

  private Integer  memberId;
  private ArrayList<Boat> boats;

  /**
  * Class constructor.
  */
  public Member(String firstName, String lastName, Double personalNumber, int memberId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.personalNumber = personalNumber;
    this.memberId = memberId;
  }
  
  /**
  * Returns member ID.
  */
  private Integer getMemberId() {
    return this.memberId;
  }
  
  /**
  * Sets the member ID.
  */
  private void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }
  
  /**
  * Returns an ArrayList of the members boats.
  */
  public ArrayList<Boat> getBoatList() {
    return boats;
  }
    
}
