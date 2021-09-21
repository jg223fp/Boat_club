package view;

import java.util.Scanner;

import model.domain.Member;
import model.domain.MemberRegistry;

/**
* A class that interacts with the user of the app via text.
*/
public class ConsoleUI {

  private Scanner console;
  //private int userChoice;
                            
  
  /**
  * Class constructor.
  */
  public ConsoleUI() {
    this.console = new Scanner(System.in);
    //this.userChoice = -1;
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
    System.out.println("3. Show compact member list");
    System.out.println("0. Exit application");
  }

  /**
  * Collects the input from the user.
  */
  public int collectUserChoice() {
    int userChoice = -1;
    // 0-5 because of main menu size.
    while (userChoice < 0 || userChoice > 3) {
      try {
        System.out.print("\nPlease enter a selection: ");
        userChoice = Integer.parseInt(console.nextLine());

      } catch (NumberFormatException e) {
        System.out.println("Invalid selection. Pleae try again.");
      }
    }
    return userChoice;
  }

  /**
  * collects string.
  */
  public String collectString(String type) {
    String input = null;
    while (input == null) {
      try {
        System.out.format("\nPlease enter a %s: ", type);
        input = console.nextLine();

      } catch (Exception e) {
        System.out.println("Invalid input. Please try again.");
      }
    }
    return input;
  }

  /**
  * collect int.
  */
  public int collectInteger(String type) {
    int input = -1;
    while (input == -1) {
      try {
        System.out.format("\nPlease enter %s: ", type);
        input = Integer.parseInt(console.nextLine());

      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please try again.");
      }
    }
    return input;
  }

  /**
  * collects Double.
  */
  public Double collectDouble(String type) {
    Double input = -1.2;
    while (input == -1.2) {
      try {
        System.out.format("\nPlease enter a %s: ", type);
        input = Double.parseDouble(console.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please try again.");
      }
    }
    return input;
  }

  /**
  * Collects long from console.
  */
  public long collectLong(String type) {
    long input = -1;
    while (input == -1) {
      try {
        System.out.format("\nPlease enter %s: ", type);
        input = Long.parseLong(console.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please try again.");
      }
    }
    return input;
  }

  /**
  * Prints information from a member object.
  */
  public void confirmMember() {
    System.out.println("\nA new member was sucessfully added.");
  }

  /**
  * Prints information from a member object.
  */
  public void printMember(MemberRegistry mReg, int memberId) {
      //TODO
  }

  /**
  * Prints a menu of the member listing alternatives.
  */
  public void showListOptions() {
      //TODO
  }

  /**
  * Prints a verbose list of the members.
  */
  public void printVerboseList() {
      //TODO
  }

  /**
  * Prints a compact list of the members.
  */
  public void printCompactList(MemberRegistry mReg) {
    try {
      System.out.println("\nMemberID:\tName:\t\t\tNumber of boats:");
      for (Member m : mReg.getMemberList()) {
        String firstName = m.getFirstName();
        String lastName = m.getLastName();
        int memberID = m.getMemberId();
        int numOfBoats = m.getBoatList().size();
        System.out.format("%d\t\t%s %s\t\t\t\t %d\n",memberID, firstName, lastName, numOfBoats);
      }
    } catch (Exception e) {
      System.out.println("Sorry, something went wrong. Error: " + e);
    }
  }

  /**
  * Prints a menu of the available actions for a member object.
  */
  public void showMemberOptions() {
    System.out.println("\n1. View member information");
    System.out.println("2. Change member information");
    System.out.println("3. Delete member");
    System.out.println("0. Back");
  }

  /**
  * Prints the information of a member.
  */
  public void showMemberMenu() {
      //TODO
  }

  /**
  * Prints the register new boat menu.
  */
  public void registerBoat() {
      //TODO
  }

  /**
  * Prints the boats from a member object.
  */
  public void showBoats() {
      //TODO
  }
  
  /**
  * Prints the available actions for a boat object.
  */
  public void showBoatOptions() {
      //TODO
  }
    
  /**
  * Prints error message.
  */
  public void printError(String e) {
    System.out.println("Sorry there was an error. " + e);
  }
}
