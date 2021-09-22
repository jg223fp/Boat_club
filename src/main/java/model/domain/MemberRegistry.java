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
    members.remove(memberId - 1);
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
    Member m = members.get(memberId);
    return m;
  }
  
  /**
  * Generates a member ID for a new member.
  */
  private int generateMemberId() {
    int memberId = members.size() + 1;
    return memberId;
  } 
}
