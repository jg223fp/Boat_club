package controller;

import model.domain.MemberRegistry;

/**
 * A class to initiate the application.
 */
public class App {

  /**
   * Initiates app.
   */
  public static void main(String[] args) {

    String appName = "The Jolly Pirate";

    MemberRegistry memberReg = new MemberRegistry();

    User user = new User();
    user.initiateData(memberReg);    // loads stored data
    user.runApp(memberReg, appName); // start app
  }
}
