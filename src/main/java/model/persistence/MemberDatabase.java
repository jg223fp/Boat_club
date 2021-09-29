package model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import model.domain.Boat;
import model.domain.Boat.BoatType;
import model.domain.Member;
import model.domain.MemberRegistry;

/**
 * A class that handles saving and loading.
 */
public class MemberDatabase {

  /**
   * Loads stored data.
   */
  public void loadData(MemberRegistry memberReg) throws FileNotFoundException, IOException {
    File memberData = new File(System.getProperty("user.dir") + "/data/memberDB.txt");
    Scanner scan = new Scanner(memberData);

    while (scan.hasNextLine()) {
      String line = scan.nextLine();
      String[] member = line.split(",");

      // creates member and returns the member id
      int memberId = memberReg.addMember(member[0], member[1], Long.parseLong(member[2]));
      Member m = memberReg.getMember(memberId);
      int index = 3; // data for first boat.
      while (index < member.length) { // scan boats data on member line.
        String name = member[index];
        BoatType boatType = Boat.BoatType.valueOf(member[index + 1]);
        double length = Double.parseDouble(member[index + 2]);
        Boat b = new Boat(name, boatType, length);
        m.addBoat(b);
        index += 3;
      }
    }
    scan.close();
  }
}