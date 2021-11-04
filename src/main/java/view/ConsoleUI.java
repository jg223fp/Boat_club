package view;

import java.util.Scanner;
import model.domain.Boat;
import model.domain.Member;

/**
 * A class that interacts with the user of the app via text.
 */
public class ConsoleUI {

  /**
   * Enum for different string options.
   */
  public enum StringOptions {
    selectionToExit, selectionToBack, selection, memberIdToGoBack, Count
  }

  /**
   * Enum for different subject.
   */
  public enum Subject {
    boat, member, lenght, firstName, lastName, newFirstName, newLastName, name, newName,
    type, Count
  }

  /**
   * Enum for different actions.
   */
  public enum Action {
    deleted, registred, changed, created, delete, Count
  }

  /**
   * Enum for main menu options.
   */
  public enum MainMenu {
    createMember, showCompactList, showVerboseList, exitMain, Count
  }

  /**
   * Enum for member option smenu.
   */
  public enum MemberOptionsMenu {
    viewMember, changeMember, registerBoat, deleteMember, exitMemberOptions, Count
  }

  /**
   * Enum for change member menu.
   */
  public enum ChangeMemberMenu {
    firstName, lastName, boats, name, length, boatType, exitChangeMember, Count
  }

  /**
   * Enum for boot options menu.
   */
  public enum BoatOptionsMenu {
    changeInfo, deleteBoat, exitBoatOptions, Count
  }

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
    System.out.format("|   Welcome to the %s   |%n", appName);
    System.out.println("+-------------------------------------+");
  }

  /**
   * Converts subject to String.
   */
  public String subjectToString(Subject object) {
    String subject;
    switch (object) {
      case firstName:
        subject = "first name";
        break;
      case lastName:
        subject = "last name";
        break;
      case newFirstName:
        subject = "new first name";
        break;
      case newLastName: 
        subject = "new last name";
        break;  
      case name: 
        subject = "name";
        break;
      case newName: 
        subject = "new name";
        break; 
      case boat:
        subject = "boat";
        break;
      case lenght:
        subject = "lenght";
        break;
      case member:
        subject = "member"; 
        break;
      case type:
        subject = "type";
        break;  
      default:
        subject = "unknown";
        break;  
    }
    return subject;
  }

  /**
   * Converts string options to String.
   */
  public String stringOptionsToString(StringOptions alt) {
    String subject;
    switch (alt) {
      case selectionToExit:
        subject = "selection or 0 to exit";
        break;
      case memberIdToGoBack:
        subject = "memberID or 0 to go back";
        break;
      case selectionToBack:
        subject = "a selection or 0 to go back";
        break;
      case selection: 
        subject = "a selection";
        break;   
      default:
        subject = "unknown";
        break;
    }
    return subject;    
  }

  /**
   * Converts subject to String.
   */
  public String actionToString(Action a) {
    String action;
    switch (a) {
      case created:
        action = "created";
        break;
      case registred:
        action = "registred";
        break;
      case changed:
        action = "changed";
        break;
      case deleted: 
        action = "deleted";
        break; 
      case delete: 
        action = "delete";
        break;    
      default:
        action = "unknown";
        break;  
    }
    return action;
  }

  /**
   * Prints the main menu.
   */
  public MainMenu printMainMenu() {
    System.out.println("\nMain Menu");
    System.out.println("1. Create new member");
    System.out.println("2. Show verbose member list");
    System.out.println("3. Show compact member list and change members");

    int limit = MainMenu.values().length - 2;

    int selection = collectUserChoice(limit, StringOptions.selectionToExit);
    switch (selection) {
      case 0:
        return MainMenu.exitMain;
      case 1:
        return MainMenu.createMember;  
      case 2:
        return MainMenu.showVerboseList;
      case 3:
        return MainMenu.showCompactList;
      default:
        return MainMenu.exitMain;
    }
  }

  /**
   * Collects the input from the user. Limit based on available choises. Prints
   * different ending based on type argument.
   */
  public int collectUserChoice(int limit, StringOptions alt) { 
    String subject = stringOptionsToString(alt);
    int userChoice = -1;
    while (userChoice < 0 || userChoice > limit) {
      try {
        System.out.format("%nPlease enter %s: ", subject);
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
   */
  public String collectString(Subject alt) {
    String subject = subjectToString(alt);
      
    String input = null;
    while (input == null) {
      try {
        System.out.format("%nPlease enter a %s: ", subject);
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
        System.out.format("%nPlease enter the boat length: ");
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
        System.out.format("%nPlease enter personal number (10 digits): ");
        input = Long.parseLong(console.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please try again.");
      }
    }
    return input;
  }

  /**
   * Prints a confirmation based on arguments.           
   */
  public void confirmation(Subject object, Action actionChoise) {
    String subject = subjectToString(object);
    String action = actionToString(actionChoise);
    System.out.format("%nThe %s was sucessfully %s.%n", subject, action);
  }

  /**
   * Prints information from a member object.
   */
  public void printMember(Member m) {
    System.out.format("%nName: %s %s%n", m.getFirstName(), m.getLastName());
    System.out.println("MemberID: " + m.getMemberId());
    System.out.println("Personal number: " + m.getPersonalNumber());
    System.out.println("Number of boats: " + m.getNumberOfBoats());
  }

  /**
   * Prints a compact list of the members.
   */
  public void printCompactList(Iterable<Member> members) {
    try {
      System.out.format("%n%-15s %-30s %-20s%n", "MemberID:", "Name:", "Number of boats:");
      for (Member m : members) {
        String firstName = m.getFirstName();
        String lastName = m.getLastName();
        int memberId = m.getMemberId();
        int numOfBoats = m.getNumberOfBoats();
        System.out.format("%-15d %-30s %-20s%n", memberId, firstName + " " + lastName, numOfBoats);
      }
    } catch (Exception e) {
      System.out.println("Sorry, something went wrong. Error: " + e);
    }
  }

  /**
   * Prints a menu of the available actions for a member object.
   */
  public MemberOptionsMenu printMemberOptions() {
    System.out.println("\n1. View member information");
    System.out.println("2. Change member information");
    System.out.println("3. Register new boat");
    System.out.println("4. Delete member");
    
    int limit = MemberOptionsMenu.values().length - 2;

    int selection = collectUserChoice(limit, StringOptions.selectionToExit);
    switch (selection) {
      case 0:
        return MemberOptionsMenu.exitMemberOptions;
      case 1:
        return MemberOptionsMenu.viewMember; 
      case 2:
        return MemberOptionsMenu.changeMember;
      case 3:
        return MemberOptionsMenu.registerBoat;
      case 4:
        return MemberOptionsMenu.deleteMember;  
      default:
        return MemberOptionsMenu.exitMemberOptions;
    }
  }
  

  /**
   * Prints the boats from a member object.
   */
  public void printBoats(Member m) {
    System.out.format("%n%-10s %-20s %-15s %-10s%n", "Number:", "Name:", "Lenght(m):", "Type:");

    int index = 1;
    for (Boat b : m.getBoatList()) {
      System.out.format("%-10d %-20s %-15.1f %-10s%n", index, b.getName(), b.getLength(), b.getBoatType());
      index++;
    }
    System.out.println();
  }

  /**
   * Prints the available actions for a boat object.
   */
  public BoatOptionsMenu printBoatOptions() {
    System.out.println("\n1. Change boat information");
    System.out.println("2. Delete boat");
    
    int limit = BoatOptionsMenu.values().length - 2;

    int selection = collectUserChoice(limit, StringOptions.selectionToExit);
    switch (selection) {
      case 0:
        return BoatOptionsMenu.exitBoatOptions;
      case 1:
        return BoatOptionsMenu.changeInfo;
      case 2:
        return BoatOptionsMenu.deleteBoat;
      default:
        return BoatOptionsMenu.exitBoatOptions;
    }      
  }

  /**
   * Prints boat types as list.
   */
  public void printBoatTypes() {
    System.out.println("\nAvailable boat types:");
    for (int e = 0; e < Boat.BoatType.Count.ordinal(); e++) {
      System.out.format("%d. %s%n", e, (Boat.BoatType.values()[e].toString()));
    }
  }

  /**
   * Prints reassurans question and action argument.
   */
  public boolean printAreYouSure(Action actionChoise, Subject object) {
    String subject = subjectToString(object);
    String action = actionToString(actionChoise);
        
    System.out.println("\nAre you sure you want to " + action + " this " + subject + "?");
    System.out.println("1. No");
    System.out.println("2. Yes");

    int selection = collectUserChoice(2, StringOptions.selectionToBack);
    if (selection == 1) {
      return false;
    } else if (selection == 2) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Prints a menu to show options for changing an object.
   * alt = subject.member or  subject.boat.
   */
  public ChangeMemberMenu printChangeMenu(Subject alt) {
    String one;
    String two;
    String three;
    
    switch (alt) {
      case member:  
        one = "First name";
        two = "Last name";
        three = "Boats";
        break;
      case boat:  
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

    int limit = ChangeMemberMenu.values().length - 2;
    
    int selection = collectUserChoice(limit, StringOptions.selectionToExit);
    
    if (alt == Subject.member) {
      switch (selection) {
        case 0:
          return ChangeMemberMenu.exitChangeMember;
        case 1:
          return ChangeMemberMenu.firstName; 
        case 2:
          return ChangeMemberMenu.lastName;
        case 3:
          return ChangeMemberMenu.boats;
        default:
          return ChangeMemberMenu.exitChangeMember;
      }
    } else {
      switch (selection) {
        case 0:
          return ChangeMemberMenu.exitChangeMember;
        case 1:
          return ChangeMemberMenu.name;
        case 2:
          return ChangeMemberMenu.length;
        case 3:
          return ChangeMemberMenu.boatType; 
        default:
          return ChangeMemberMenu.exitChangeMember;
      }
    }  
      
  }

  /**
   * Prints error message.
   */
  public void printError(String e) {
    System.out.println("Sorry there was an error. " + e);
  }
}
