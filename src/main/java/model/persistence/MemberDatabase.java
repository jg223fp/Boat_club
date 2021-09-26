package model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.domain.Boat;
import model.domain.Member;
import model.domain.MemberRegistry;
//mport model.domain.Boat.BoatType;

/**
 * A class that handles saving and loading.
 */
public class MemberDatabase {


  /**
  * Loads stored data. 
   * @throws FileNotFoundException
  */
  public void loadData(MemberRegistry memberReg) throws FileNotFoundException {
      File memberData = new File(System.getProperty("user.dir") + "/data/memberDB.txt");
      Scanner scan = new Scanner(memberData);
      
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        String[] member = line.split(",");
        
        int memberId = memberReg.addMember(member[0], member[1], Long.parseLong(member[2]));  // creates member and returns the member id
        Member m = memberReg.getMember(memberId);
        int index = 3; //data for first boat.
        while (index < member.length) { //scan boats data on member line.
          Boat b = new Boat(member[index], Boat.BoatType.valueOf(member[index + 1]), Double.parseDouble(member[index + 2]));
          m.addBoat(b);
          index += 3;
        }
      }
      scan.close();
  }
}