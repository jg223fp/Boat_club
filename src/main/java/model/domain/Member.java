package model.domain;

import java.util.ArrayList;

/**
* @generated
*/
public class Member extends Person {

  private Integer  memberID;
  private ArrayList<Boat> boats;

  public Member(String firstName, String lastName, int personalNumber, int memberID) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.personalNumber = personalNumber;
    this.memberID = memberID;
  }
  
  /**
  * @generated
  */
  private Integer getMemberID() {
    return this.memberID;
  }
  
  /**
  * @generated
  */
  private void setMemberID(Integer memberID) {
    this.memberID = memberID;
  }
  
  /**
  * @generated
  */
  public ArrayList<Boat> getBoatList() {
    return boats;
  }
    
}
