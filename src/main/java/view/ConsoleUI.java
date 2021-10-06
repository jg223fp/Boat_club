package view;

import java.util.Scanner;
import model.domain.Boat;
import model.domain.Member;
import model.domain.MemberRegistry;

/**
 * A class that interacts with the user of the app via text.
 */
public class ConsoleUI {

  private Scanner console;

  /**
   * Class constructor.
   */
  public ConsoleUI() {
    this.console = new Scanner(System.in);
  }

  /**
   * Prints app header.
   */
  public void printHeader(String appName) {
    System.out.println("+-------------------------------------+");
    System.out.format("|   Welcome to the %s   |\n", appName);
    System.out.println("+-------------------------------------+");
  }

  /**
   * Prints the main menu.
   */
  public void printMainMenu() {
    System.out.println("\nMain Menu");
    System.out.println("1. Create new member");
    System.out.println("2. Show verbose member list");
    System.out.println("3. Show compact member list and change members");
  }

  /**
   * Collects the input from the user. Limit based on available choises. Prints
   * different ending based on type argument.
   * alt = 0: "selection or 0 to exit"         1: "memberID or 0 to go back"
   *       2: "a selection or 0 to go back"    3: "a selection"
   */
  public int collectUserChoice(int limit, int alt) {
    String subject;
    switch (alt) {
      case 0:
        subject = "selection or 0 to exit";
        break;
      case 1:
        subject = "memberID or 0 to go back";
        break;
      case 2:
        subject = "a selection or 0 to go back";
        break;
      case 3: 
        subject = "a selection";
        break;   
      default:
        subject = "unknown";
        break;  
    }
    int userChoice = -1;
    while (userChoice < 0 || userChoice > limit) {
      try {
        System.out.format("\nPlease enter %s: ", subject);
        userChoice = Integer.parseInt(console.nextLine());
        if (userChoice < 0 || userChoice > limit) {
          throw new NumberFormatException();
        }

      } catch (NumberFormatException e) {
        System.out.println("Invalid selection. Please try again.");
      }
    }
    return userChoice;
  }

  /**
   * Collects string. Prints type argument.
   * alt = 0: first name      1: last name
   *       2: new first name  3: new last name
   *       4: name            5: new name.
   */
  public String collectString(int alt) {
    String subject;
    switch (alt) {
      case 0:
        subject = "first name";
        break;
      case 1:
        subject = "last name";
        break;
      case 2:
        subject = "new first name";
        break;
      case 3: 
        subject = "new last name";
        break;  
      case 4: 
        subject = "name";
        break;
      case 5: 
        subject = "new name";
        break; 
      default:
        subject = "unknown";
        break;  
    }    
    String input = null;
    while (input == null) {
      try {
        System.out.format("\nPlease enter a %s: ", subject);
        input = console.nextLine();

      } catch (Exception e) {
        System.out.println("Invalid input. Please try again.");
      }
    }
    return input;
  }

  /**
   * Collects Double. Prints type argument.
   */
  public Double collectBoatLength() {
    Double input = -1.2;
    while (input < 0) {
      try {
        System.out.format("\nPlease enter the boat length: ");
        input = Double.parseDouble(console.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please try again.");
      }
    }
    return input;
  }

  /**
   * Collects long from console.Prints type argument.
   */
  public long collectPersonalNumber() {
    long input = -1;
    while (input < 0) {
      try { 
        System.out.format("\nPlease enter personal number (10 digits): ");
        input = Long.parseLong(console.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please try again.");
      }
    }
    return input;
  }

  /**
   * Prints a confirmation based on arguments.
   * objectChoise = 0: member  1: first name
   *                2: last name  3: boat
   *                4: name       5: lenght
   *                6: type
   * actionChoise = 0: created  1: deleted
   *                2: changed  3: registred.             
   */
  public void confirmation(int objectChoise, int actionChoise) {
    String object;
    String action;

    switch (objectChoise) {
      case 0:
        object = "member";
        break;
      case 1:
        object = "first name";
        break;
      case 2:
        object = "last name";
        break;
      case 3: 
        object = "boat";
        break;
      case 4: 
        object = "name";
        break;
      case 5: 
        object = "length";
        break;
      case 6: 
        object = "type";
        break;  
      default:
        object = "unknown";
        break;  
    }
    switch (actionChoise) {
      case 0:
        action = "created";
        break;
      case 1:
        action = "deleted";
        break;
      case 2:
        action = "changed";
        break;
      case 3: 
        action = "registred";
        break;   
      default:
        action = "unknown";
        break;  
    }
    System.out.format("\nThe %s was sucessfully %s.\n", object, action);
  }

  /**
   * Prints information from a member object.
   */
  public void printMember(Member m) {
    System.out.format("\nName: %s %s\n", m.getFirstName(), m.getLastName());
    System.out.println("MemberID: " + m.getMemberId());
    System.out.println("Personal number: " + m.getPersonalNumber());
    System.out.println("Number of boats: " + m.getNumberOfBoats());
  }

  /**
   * Prints a compact list of the members.
   */
  public void printCompactList(MemberRegistry memberReg) {
    try {
      System.out.format("\n%-15s %-30s %-20s\n", "MemberID:", "Name:", "Number of boats:");
      for (Member m : memberReg.getMemberList()) {
        String firstName = m.getFirstName();
        String lastName = m.getLastName();
        int memberId = m.getMemberId();
        int numOfBoats = m.getNumberOfBoats();
        System.out.format("%-15d %-30s %-20s\n", memberId, firstName + " " + lastName, numOfBoats);
      }
    } catch (Exception e) {
      System.out.println("Sorry, something went wrong. Error: " + e);
    }
  }

  /**
   * Prints a menu of the available actions for a member object.
   */
  public void printMemberOptions() {
    System.out.println("\n1. View member information");
    System.out.println("2. Change member information");
    System.out.println("3. Register new boat");
    System.out.println("4. Delete member");
  }

  /**
   * Prints the boats from a member object.
   */
  public void printBoats(Member m) {
    System.out.format("\n%-10s %-20s %-15s %-10s\n", "Number:", "Name:", "Lenght(m):", "Type:");

    int index = 1;
    for (Boat b : m.getBoatList()) {
      System.out.format("%-10d %-20s %-15.1f %-10s\n", index, b.getName(), b.getLength(), b.getBoatType());
      index++;
    }
    System.out.println();
  }

  /**
   * Prints the available actions for a boat object.
   */
  public void printBoatOptions() {
    System.out.println("\n1. Change boat information");
    System.out.println("2. Delete boat");
  }

  /**
   * Prints boat types as list.
   */
  public void printBoatTypes() {
    System.out.println("\nAvailable boat types:");
    for (int e = 0; e < Boat.BoatType.Count.ordinal(); e++) {
      System.out.format("%d. %s\n", e, (Boat.BoatType.values()[e].toString()));
    }
  }

  /**
   * Prints reassurans question and action argument.
   * alt = 0: delete member  1: delete boat.
   */
  public void printAreYouSure(int alt) {
    String subject;
    switch (alt) {
      case 0:
        subject = "you want to delete this member";
        break;
      case 1:
        subject = "you want to delete this boat";
        break;
      default:
        subject = "unknown";  
        break;
    }      
    System.out.println("\nAre you sure you want to " + subject + "?");
    System.out.println("1. No");
    System.out.println("2. Yes");
  }

  /**
   * Prints a menu to show options for changing an object.
   * alt = 0: member  1: boat.
   */
  public void printChangeMenu(int alt) {
    String one;
    String two;
    String three;
    switch (alt) {
      case 0:    // member
        one = "First name";
        two = "Last name";
        three = "Boats";
        break;
      case 1:   // boat
        one = "Name";
        two = "Length";
        three = "Boat type";
        break;
      default:
        one = "unknown";
        two = "unknown";
        three = "unknown";  
        break;
    }  
    System.out.println("\nWhat do you want to change?");
    System.out.println("1. " + one);
    System.out.println("2. " + two);
    System.out.println("3. " + three);
  }

  /**
   * Prints error message.
   */
  public void printError(String e) {
    System.out.println("Sorry there was an error. " + e);
  }
}
