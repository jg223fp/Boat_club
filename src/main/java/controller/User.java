package controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import model.domain.Member;
import model.domain.MemberRegistry;
import view.ConsoleUI;

/**
 * "Main" class. It is in this class the program is running
 */
public class User {

  /**
   * Initiates the application.
   */
  public void runApp(MemberRegistry memberReg, String appName) {

    ConsoleUI ui = new ConsoleUI();
    ui.printHeader(appName); // present app name

    boolean exit = false;

    while (!exit) {
      ui.printMainMenu();

      switch (ui.collectUserChoice(3)) {
        case 0:
          exit = true;
          // SAVE MEMBERS HERE!!!!
          break;
        case 1:
          createMember(memberReg);
          break;
        case 2:
          showVerboseMemberList(memberReg);
          break;
        case 3:
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
    String firstName = ui.collectString("first name");
    String lastName = ui.collectString("last name");
    long personalNumber = ui.collectLong("personal number (10 digits)");

    try {
      int iD = memberReg.addMember(firstName, lastName, personalNumber);
      Member m = memberReg.getMember(iD);

    } catch (NullPointerException e) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      e.printStackTrace(pw);
      String stackTrace = sw.toString(); // convert stacktrace to string;
      ui.printError(stackTrace);
    }
    ui.confirmation("member", "created");
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
    ui.printCompactList(memberReg);
    int input = ui.collectInteger("memberID or 0 to go back");
    if (input != 0) {
      ui.printMemberOptions();
      Member m = memberReg.getMember(input); // fetch member
      switch (ui.collectUserChoice(3)) {
        case 0:
          break;
        case 1:
          ui.printMember(m);
          if (m.getNumberOfBoats() > 0) {
            ui.printBoats(m);
          }
          break;
        case 2:
          changeMember(m);
          break;
        case 3:
          ui.printAreYouSure("you want to delete this member");
          if (ui.collectUserChoice(1) == 1) {
            memberReg.deleteMember(input);
            ui.confirmation("member", "deleted");
          }
          break;
        default:
          break;
      }
    }
  }

  /**
   * Change a member objects information.
   */
  private void changeMember(Member m) {
    ConsoleUI ui = new ConsoleUI();
    ui.printChangeUserMenu();
    switch (ui.collectUserChoice(3)) {
      case 0:
        break;
      case 1:
        String firstName = ui.collectString("new first name");
        m.setFirstName(firstName);
        ui.confirmation("first name", "changed");
        break;
      case 2:
        String lastName = ui.collectString("new last name");
        m.setLastName(lastName);
        ui.confirmation("last name", "changed");
        break;
      case 3:
        break;
      default:
        break;
    }

  }

  /**
   * Starts the process of register a new boat on a member.
   */
  private void registerBoat() {
    // TODO
  }

  /**
   * Starts the process of changing boat information.
   */
  private void changeBoat() {
    // TODO
  }

  /**
   * Starts the process of removing a boat.
   */
  private void removeBoat() {
    // TODO
  }

}
