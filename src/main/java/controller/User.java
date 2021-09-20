package controller;

import java.util.ArrayList;

import model.domain.Member;
import view.ConsoleUI;

/**
* "Main" class. It is in this class the program is running
*/
public class User {

  public User() {
    
  }
                                   
  /**
  * Initiates the application.
  */
  public void runApp(ArrayList<Member> mReg, String appName) {

    ConsoleUI ui = new ConsoleUI();
    ui.printHeader(appName);          // present app name
    

    boolean exit = false;

    while (!exit) {  
      ui.printMainMenu();

      switch (ui.collectUserChoice()) {
        case 0:
          exit = true; 
          // SAVE MEMBERS HERE!!!!   
          break;        
        case 1:
          createMember();
          break;
        case 2:
          showMemberList();
          break;  
      }
    } 
  }

  /**
  * Starts the process of creating a new member.
  */
  private void createMember() {
      //TODO
  }

  /**
  * Displays memberlist.
  */
  private void showMemberList() {
      //TODO
  }

  /**
  * Change a member objects information.
  */
  private void changeMember() {
      //TODO
  }

  /**
  * Starts the process of removing a member.
  */
  private void removeMember() {
      //TODO
  }

  /**
  * Starts the process of register a new boat on a member.
  */
  private void registerBoat() {
      //TODO
  }

  /**
  * Starts the process of changing boat information.
  */
  private void changeBoat() {
      //TODO
  }

  /**
  * Starts the process of removing a boat.
  */
  private void removeBoat() {
      //TODO
  }
    
}
