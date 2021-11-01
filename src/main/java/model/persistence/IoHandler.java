package model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import model.domain.Boat;
import model.domain.Boat.BoatType;
import model.domain.Member;
import model.domain.MemberRegistry;

/**
 * Handles the IO for model classes.
 */
public class IoHandler {

  /**
   * Loads members and puts them in a member registry.
   */
  public void loadMembers(MemberRegistry memberReg) throws FileNotFoundException {
    File memberData = new File(System.getProperty("user.dir") + "/data/memberDB.txt");
    Scanner scan = new Scanner(memberData);

    while (scan.hasNextLine()) {
      String line = scan.nextLine();
      String[] member = line.split(",");

      // creates member and returns the member id
      Member m = memberReg.addMember(member[0], member[1], Long.parseLong(member[2]));
      int index = 3; // data for first boat.
      while (index < member.length) { // scan boats data on member line.
        String name = member[index];
        BoatType boatType = Boat.BoatType.valueOf(member[index + 1]);
        double length = Double.parseDouble(member[index + 2]);
        //Boat b = new Boat(name, boatType, length);
        m.addBoat(name, boatType, length);
        index += 3;
      }
    }
    scan.close();
  }
}
