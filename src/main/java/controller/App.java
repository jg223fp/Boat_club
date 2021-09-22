package controller;

import model.domain.MemberRegistry;

/**
 * A class to initiate the application.
 */
public class App {

  public static void main(String[] args) {

    String appName = "The jolly pirate";

    MemberRegistry mReg = new MemberRegistry();
    mReg.addMember("Farbror", "Melker", 5502148755L); //test member
    mReg.addMember("Kapten", "Hadok", 6403154412L); //test member
    mReg.addMember("Palle", "Kuling", 9999999999L); //test member

    
    User user = new User();
    user.runApp(mReg, appName); // initiates app
  }
}
