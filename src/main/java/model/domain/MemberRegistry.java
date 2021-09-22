package model.domain;

import java.util.ArrayList;

/**
* A class that stores all member objects.
*/
public class MemberRegistry {
    
  private ArrayList<Member> members;
  
  /**
  * Class constructor.
  */
  public MemberRegistry() {
    this.members = new ArrayList<Member>();
  }
  
  /**
  * Creates a new member and returns the member ID.
  */
  public int addMember(String firstName, String lastName, long personalNumber) {
    int memberId = generateMemberId();
    Member m = new Member(firstName, lastName, personalNumber, memberId);
    members.add(m);
    return memberId;
  }

  /**
  * Deletes a member.
  */
  public void deleteMember(int memberId) {
    for (Member m: members) {
      if (m.getMemberId() == memberId) {
        members.remove(m);
        break;
      }
    }  
  }
  
  /**
  * Returns the member list.
  */
  public Iterable<Member> getMemberList() {
    return members;
  }
  
  /**
  * Returns a member object from a given memberId.
  */
  public Member getMember(int memberId) {
    for (Member m: members) {
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
}
