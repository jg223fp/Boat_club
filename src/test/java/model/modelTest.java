package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import model.domain.Boat;
import model.domain.Boat.BoatType;
import model.domain.Member;
import model.domain.MemberRegistry;

public class modelTest {

    /**
     * Tries to create a member and add to the member registry.
     */
    @Test
    public void testRegisterNewMember() {
        MemberRegistry memreg = new MemberRegistry();
        int memberId = memreg.addMember("Jonny", "Stål", 1234567890L);

        assertTrue(memreg.getMember(memberId) != null, "Member was not added properly");
    }

    /**
     * Tries to register a boat on a member.
     */
    @Test
    public void testRegisterNewBoat() {
        Boat b = new Boat("Titanic", BoatType.Motorsailer, 8.5);
        Member m = new Member("Jonny", "Stål", 1234567890L, 1);
        m.addBoat(b);

        assertTrue(m.getBoat(1) != null, "Boat was not added properly");
    }

}
