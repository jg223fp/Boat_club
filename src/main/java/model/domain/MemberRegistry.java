package model.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.domain.Boat;
import model.domain.Boat.BoatType;
import model.domain.Member;
import model.domain.MemberRegistry;
import model.persistence.Loadable;

/**
 * A class that stores all member objects.
 */
public class MemberRegistry implements Loadable {

  private ArrayList<Member> members;

  /**
   * Class constructor.
   */
  public MemberRegistry() {
    this.members = new ArrayList<Member>();
  }

  /**
   * Creates a new member and ads to member registry.
   */
  public Member addMember(String firstName, String lastName, long personalNumber) {
    int memberId = generateMemberId();
    Member m = new Member(firstName, lastName, personalNumber, memberId);
    members.add(m);
    return m;
  }

  /**
   * Deletes a member.
   */
  public void deleteMember(int memberId) {
    for (Member m : members) {
      if (m.getMemberId() == memberId) {
        members.remove(m);
        break;
      }
    }
  }

  /**
   * Returns an iterable member list.
   */
  public Iterable<Member> getMemberList() {
    return members;
  }

  /**
   * Returns the number of members.
   */
  public int getNumberOfMembers() {
    int number = members.size();
    return number;
  }

  /**
   * Returns a member object from a given memberId.
   */
  public Member getMember(int memberId) {
    for (Member m : members) {
      if (m.getMemberId() == memberId) {
        return m;
      }
    }
    return null;
  }

  /**
   * Generates a member ID for a new member.
   */
  private int generateMemberId() {
    int memberId = 0;
    for (Member m : members) {
      if (m.getMemberId() >= memberId) {
        memberId = m.getMemberId();
      }
    }
    return memberId + 1;
  }

  /**
   * A method from the loadable interface. Loads all members and their boats
   */
  @Override
  public void loadData() throws FileNotFoundException {
    File memberData = new File(System.getProperty("user.dir") + "/data/memberDB.txt");
    Scanner scan = new Scanner(memberData);

    while (scan.hasNextLine()) {
      String line = scan.nextLine();
      String[] member = line.split(",");

      // creates member and returns the member id
      Member m = this.addMember(member[0], member[1], Long.parseLong(member[2]));
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
