package controller;

import model.domain.MemberRegistry;

/**
 * A class to initiate the application.
 */
public class App {

  public static void main(String[] args) {

    String appName = "Boatclub system v1.0";

    MemberRegistry mReg = new MemberRegistry();
    User user = new User();
    user.runApp(mReg, appName); // initiates app
  }
}
