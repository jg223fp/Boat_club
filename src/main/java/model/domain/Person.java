package model.domain;


/**
* A class repretsenting a person.
*/
public class Person {
    
  protected String firstName;
  protected String lastName;
  protected long personalNumber;
  
  /**
  * Returns the name of the person.
  */
  private String getFirstName() {
    return this.firstName;
  }
  
  /**
  * Sets the first name of the person.
  */
  private void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  /**
  * Returns the last name of the person.
  */
  private String getLastName() {
    return this.lastName;
  }
  
  /**
  * Sets the last name of the person.
  */
  private void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  /**
  * Returns the personal number of the person.
  */
  private long getPersonalNumber() {
    return this.personalNumber;
  }
  
  /**
  * Sets the personal number of the person.
  */
  private void setPersonalNumber(long personalNumber) {
    this.personalNumber = personalNumber;
  }   
}
