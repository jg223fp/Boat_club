package controller;

import model.domain.MemberRegistry;

/**
* A class to initiate the application.
*/
public class App {
  
  private String appName = "Boatclub system v1.0";

  public static void main(String[] args) {

    MemberRegistry mReg = new MemberRegistry(); 
    User user = new User(mReg, appName);
    user.runApp();                                //initiates app
  }
}


