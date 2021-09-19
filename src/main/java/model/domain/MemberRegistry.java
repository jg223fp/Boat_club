package model.domain;
import java.util.ArrayList;

public class MemberRegistry {
    
    private ArrayList<Member> members;
    
    
    public MemberRegistry() {
        //TODO
    }
    
    public Member addMember(String firstName, String lastName, int personalNumber) {
        int memberID = generateMemberID();
        Member m = new Member(firstName, lastName, personalNumber, memberID);
        return m;
    }

    public void deleteMember(Member m) {
        members.remove(m);
    }
    
    public ArrayList<Member> getMemberList() {
        return members;
    }
    
    public Member getMember(int index) {
        Member m = members.get(index);
        return m;
    }
    
    private int generateMemberID() {
        int memberID = members.size();
        memberID++;
        return memberID;
    } 
}
