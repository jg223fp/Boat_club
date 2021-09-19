package model.domain;

public class Boat {

    private String name;
    private Enum boatType;
    private float length;
    
    
    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private Enum getBoatType() {
        return this.boatType;
    }

    private void setBoatType(Enum boatType) {
        this.boatType = boatType;
    }

    private float getLength() {
        return this.length;
    }

    private void setLength(float length) {
        this.length = length;
    }
}
