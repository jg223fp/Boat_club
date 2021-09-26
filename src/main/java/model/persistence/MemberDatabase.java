package model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.domain.MemberRegistry;

/**
 * A class that handles saving and loading.
 */
public class MemberDatabase {

  /**
  * Loads stored data. 
   * @throws FileNotFoundException
  */
  public void loadData(MemberRegistry memberReg) {
    try {
      
      File memberData = new File(System.getProperty("user.dir") + "/data/memberDB.txt");
      Scanner scan = new Scanner(memberData);

      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        String[] member = line.split(",");
        memberReg.addMember(member[0], member[1], Long.parseLong(member[2]));
      }
      scan.close();

    } catch (NullPointerException e) {

    } catch (Exception e) {
      
    }
  }
}
