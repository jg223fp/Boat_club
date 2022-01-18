package controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import model.domain.Boat;
import model.domain.Boat.BoatType;
import model.domain.Member;
import model.domain.MemberRegistry;
import view.ConsoleUI;
import view.ConsoleUI.Action;
import view.ConsoleUI.BoatOptionsMenu;
import view.ConsoleUI.ChangeMemberMenu;
import view.ConsoleUI.MainMenu;
import view.ConsoleUI.MemberOptionsMenu;
import view.ConsoleUI.StringOptions;
import view.ConsoleUI.Subject;

/**
 * "Main" class. It is in this class the program is running.
 */
public class User {

  /**
   * Fetches stored data and puts in the memberregistry.
   */
  public void initiateData(MemberRegistry memberReg) {
    ConsoleUI ui = new ConsoleUI();

    try {
      memberReg.loadData();

    } catch (Exception e) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      e.printStackTrace(pw);
      String stackTrace = sw.toString(); // convert stacktrace to string;
      ui.printError(stackTrace); // print exception
    }
  }

  /**
   * starts the application.
   */
  public void runApp(MemberRegistry memberReg, String appName) {

    ConsoleUI ui = new ConsoleUI();
    ui.printHeader(appName); // present app name

    boolean exit = false;

    while (!exit) {
      MainMenu userChoice = ui.printMainMenu();

      switch (userChoice) {
        case exitMain:
          exit = true;
          break;
        case createMember:
          createMember(memberReg);
          break;
        case showVerboseList:
          showVerboseMemberList(memberReg);
          break;
        case showCompactList :
          showCompactMemberList(memberReg);
          break;
        default:
          break;
      }
    }
  }

  /**
   * Starts the process of creating a new member.
   */
  private void createMember(MemberRegistry memberReg) {
    ConsoleUI ui = new ConsoleUI();
    String firstName = ui.collectString(Subject.firstName);
    String lastName = ui.collectString(Subject.lastName);
    String pwd = ui.collectString(Subject.password);
    long personalNumber = 0;

    while (personalNumber < 1000000000L || personalNumber > 9999999999L) {
      personalNumber = ui.collectPersonalNumber();
    }
    memberReg.addMember(firstName, lastName, personalNumber,pwd);

    ui.confirmation(Subject.member, Action.registred);
  }

  /**
   * Displays a verbose memberlist.
   */
  private void showVerboseMemberList(MemberRegistry memberReg) {
    ConsoleUI ui = new ConsoleUI();
    for (Member m : memberReg.getMemberList()) {
      ui.printMember(m);
      if (m.getNumberOfBoats() > 0) {
        ui.printBoats(m);
      }
    }
  }

  /**
   * Displays a compact memberlist.
   */
  private void showCompactMemberList(MemberRegistry memberReg) {
    ConsoleUI ui = new ConsoleUI();

    ui.printCompactList(memberReg.getMemberList());
    int input = ui.collectUserChoice(memberReg.getNumberOfMembers(), StringOptions.memberIdToGoBack);

    while (input != 0) {
      MemberOptionsMenu userChoice = ui.printMemberOptions();
      Member m = memberReg.getMember(input); // fetch member
      switch (userChoice) {
        case exitMemberOptions:
          input = 0;
          break;
        case viewMember:
          ui.printMember(m);
          if (m.getNumberOfBoats() > 0) {
            ui.printBoats(m);
          }
          break;
        case changeMember:
          changeMember(m);
          break;
        case registerBoat:
          registerBoat(m);
          break;
        case deleteMember:
          if (deleteMember(memberReg, input)) {
            input = 0;
          }
          break;
        default:
          break;
      }
    }
  }

  /**
   * Delete a member object.
   */
  private Boolean deleteMember(MemberRegistry memberReg, int memberId) {
    ConsoleUI ui = new ConsoleUI();
    boolean userSure = ui.printAreYouSure(Action.delete, Subject.member);
    if (userSure) {
      memberReg.deleteMember(memberId);
      ui.confirmation(Subject.member, Action.deleted);
      return true;
    }
    return false;
  }

  /**
   * Change a member objects information.
   */
  private void changeMember(Member m) {
    ConsoleUI ui = new ConsoleUI();
    ChangeMemberMenu input = null;

    while (input != ChangeMemberMenu.exitChangeMember) {
      input = ui.printChangeMenu(Subject.member);
      //input = ui.collectUserChoice(3, StringOptions.selectionToBack);

      switch (input) {
        case exitChangeMember:
          break;
        case firstName:
          String firstName = ui.collectString(Subject.newFirstName);
          m.setFirstName(firstName);
          ui.confirmation(Subject.firstName, Action.changed);
          break;
        case lastName:
          String lastName = ui.collectString(Subject.newLastName);
          m.setLastName(lastName);
          ui.confirmation(Subject.lastName, Action.changed);
          break;
        case boats:
          boatMenu(m);
          break;
        default:
          break;
      }
    }
  }

  /**
   * Starts the process of register a new boat on a member.
   */
  private void boatMenu(Member m) {
    ConsoleUI ui = new ConsoleUI();
    if (m.getNumberOfBoats() > 0) {
      ui.printBoats(m);
    }
    int input = ui.collectUserChoice(m.getNumberOfBoats(), StringOptions.selectionToBack);

    while (input != 0) {
      BoatOptionsMenu userChoice = ui.printBoatOptions();
      Boat b = m.getBoat(input);
      switch (userChoice) {
        case exitBoatOptions:
          input = 0;
          break;
        case changeInfo:
          changeBoat(b);
          break;
        case deleteBoat:
          Boolean userSure = ui.printAreYouSure(Action.delete, Subject.boat);
          if (userSure) {
            m.deleteBoat(input);
            ui.confirmation(Subject.boat, Action.deleted);
          }
          input = 0;
          break;
        default:
          break;
      }
    }
  }

  /**
   * Starts the process of register a new boat on a member.
   */
  private void registerBoat(Member m) {
    ConsoleUI ui = new ConsoleUI();
    String name = ui.collectString(Subject.name);
    Double lenght = ui.collectBoatLength();
    ui.printBoatTypes();
    int numberOfTypes = Boat.BoatType.values().length - 2;
    int i = ui.collectUserChoice(numberOfTypes, StringOptions.selection); // collects user choise
    BoatType type = Boat.BoatType.values()[i]; // set variable value depending on user choise

    try {
      m.addBoat(name, type, lenght);

    } catch (NullPointerException e) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      e.printStackTrace(pw);
      String stackTrace = sw.toString(); // convert stacktrace to string;
      ui.printError(stackTrace);
    }
    ui.confirmation(Subject.boat, Action.registred);

  }

  /**
   * Starts the process of changing boat information.
   */
  private void changeBoat(Boat b) {
    ConsoleUI ui = new ConsoleUI();
    ChangeMemberMenu input = null;

    while (input != ChangeMemberMenu.exitChangeMember) {
      input = ui.printChangeMenu(Subject.boat);

      switch (input) {
        case exitChangeMember:
          break;
        case name:
          String name = ui.collectString(Subject.newName);
          b.setName(name);
          ui.confirmation(Subject.name, Action.changed);
          break;
        case length:
          Double length = ui.collectBoatLength();
          b.setLength(length);
          ui.confirmation(Subject.lenght, Action.changed);
          break;
        case boatType:
          changeBoatType(b);
          break;
        default:
          break;
      }
    }
  }

  /**
   * Change a boats type.
   */
  private void changeBoatType(Boat b) {
    ConsoleUI ui = new ConsoleUI();
    ui.printBoatTypes();

    // get number of options from enum (-2 because of count at end of enum and array
    // start with 0)
    int numberOfTypes = Boat.BoatType.values().length - 2;

    int i = ui.collectUserChoice(numberOfTypes, StringOptions.selection); // collects user choise
    BoatType type = Boat.BoatType.values()[i]; // set variable value depending on user choise
    b.setBoatType(type);
    ui.confirmation(Subject.type, Action.changed);
  }
}
