package model.domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import model.domain.MemberRegistry;
import model.persistence.DbInterface;
import model.persistence.IoHandler;

/**
 * A class that stores all member objects.
 */
public class MemberRegistry implements DbInterface {

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
   * A method from the loadable interface. Loads all members and their boats.
   */
  @Override
  public void loadData() throws FileNotFoundException {
    IoHandler io = new IoHandler();
    io.loadMembers(this);
  }
}
