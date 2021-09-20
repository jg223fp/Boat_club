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
  * Creates a new member and returns the member object.
  */
  public Member addMember(String firstName, String lastName, int personalNumber) {
    int memberId = generateMemberId();
    Member m = new Member(firstName, lastName, personalNumber, memberId);
    members.add(m);
    return m;
  }

  /**
  * Deletes a member.
  */
  public void deleteMember(Member m) {
    members.remove(m);
  }
  
  /**
  * Returns the member list.
  */
  public ArrayList<Member> getMemberList() {
    return members;
  }
  
  /**
  * Returns a member object from a given index.
  */
  public Member getMember(int index) {
    Member m = members.get(index);
    return m;
  }
  
  /**
  * Generates a member ID for a new member.
  */
  private int generateMemberId() {
    int memberId = members.size();
    memberId++;
    return memberId;
  } 
}
