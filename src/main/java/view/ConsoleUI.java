package view;

import java.util.Scanner;

import model.domain.Member;
import model.domain.MemberRegistry;
import model.domain.Boat;

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
  public int collectUserChoice(int limit) {
    int userChoice = -1;
    // 0-5 because of main menu size.
    while (userChoice < 0 || userChoice > limit) {
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
  * Prints a confirmation that an object was sucessfully added.
  */
  public void confirmation(String type,String action) {
    System.out.format("\nThe %s was sucessfully %s.\n",type,action);
  }

  /**
  * Prints information from a member object.
  */
  public void printMember(Member m) {
      System.out.format("\nName: %s %s\n", m.getFirstName(),m.getLastName()); 
      System.out.println("MemberID: " + m.getMemberId());
      System.out.println("Personal number: " + m.getPersonalNumber());
      System.out.println("\nNumber of boats: " + m.getNumberOfBoats());
  }

  /**
  * Prints a compact list of the members.
  */
  public void printCompactList(MemberRegistry memberReg) {
    try {
      System.out.println("\nMemberID:\tName:\t\t\tNumber of boats:");
      for (Member m : memberReg.getMemberList()) {
        String firstName = m.getFirstName();
        String lastName = m.getLastName();
        int memberID = m.getMemberId();
        int numOfBoats = m.getNumberOfBoats();
        System.out.format("%d\t\t%s %s\t\t\t\t %d\n",memberID, firstName, lastName, numOfBoats);
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
    System.out.println("3. Delete member");
    System.out.println("0. Back");
  }

  /**
  * Prints the information of a member.
  */
  public void printMemberMenu() {
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
  public void printBoats(Member m) {
    System.out.format("\n%-20s %-10s %-10s\n","Name:","Lenght:","Type:");
    for (Boat b: m.getBoatList()) {
      System.out.format("%-20s %-10.1f %-10s\n",b.getName(),b.getLength(),b.getBoatType());
    }
    System.out.println();
  }
  
  /**
  * Prints the available actions for a boat object.
  */
  public void printBoatOptions() {
      //TODO
  }

  /**
  * Prits reassurans question.
  */
  public void printAreYouSure(String action) {
    System.out.println("Are you sure you want to " + action + "?");
    System.out.println("1. Yes");
    System.out.println("2. No");

  }
    
  /**
  * Prints error message.
  */
  public void printError(String e) {
    System.out.println("Sorry there was an error. " + e);
  }
}
