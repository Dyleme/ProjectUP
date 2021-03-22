package Renatble;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rentableHouse")
public class RentableHouse extends RentableForLiving {
    @JsonProperty("IsGarage")
    protected boolean isGarageExist;

    @JsonProperty("OutsideArea")
    protected int outsideArea;

    public RentableHouse(Address address, int pricePerMonth, int area, int floorsNumber, int bedroomsAmount,
                         int roomsAmount, int peopleAmount, boolean isKitchenExist) {
        super(address, pricePerMonth, area, floorsNumber, bedroomsAmount, roomsAmount, peopleAmount, isKitchenExist);
    }

    public RentableHouse() {
        super();
    }

    @XmlElement()
    public boolean getIsGarageExist() {
        return isGarageExist;
    }

    @XmlElement()
    public int getOutsideArea() {
        return outsideArea;
    }

    public void setIsGarageExist(boolean garageExist) {
        isGarageExist = garageExist;
    }

    public void setOutsideArea(int outsideArea) {
        this.outsideArea = outsideArea;
    }
}
