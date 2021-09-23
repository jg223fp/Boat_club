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
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Sets the first name of the person.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Returns the last name of the person.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Sets the last name of the person.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Returns the personal number of the person.
   */
  public long getPersonalNumber() {
    return this.personalNumber;
  }
}
