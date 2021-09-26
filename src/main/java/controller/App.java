package controller;

import model.domain.Boat;
//import model.domain.Boat.BoatType;
import model.domain.Member;
import model.domain.MemberRegistry;
import model.persistence.MemberDatabase;

/**
 * A class to initiate the application.
 */
public class App {

  /**
   * Initiates app.
   */
  public static void main(String[] args) {

    String appName = "The Jolly Pirate";
    System.out.println(System.getProperty("user.dir"));

    MemberRegistry memberReg = new MemberRegistry();
    MemberDatabase memberDB = new MemberDatabase();
    memberDB.loadData(memberReg);

    // adding test boats
    Member m = memberReg.getMember(1);
    Boat b = new Boat("Ekan", Boat.BoatType.Canoe, 4.5);
    Boat b1 = new Boat("Titanic", Boat.BoatType.Other, 269);
    m.addBoat(b);
    m.addBoat(b1);

    User user = new User();
    user.runApp(memberReg, appName); // initiates app
  }
}
