package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "rentableHouse")
@XmlType(propOrder = { "isGarageExist", "outsideArea" })
public class RentableHouse extends RentableForLiving {
    @JsonProperty("IsGarage")
    protected boolean isGarageExist;

    @JsonProperty("OutsideArea")
    protected int outsideArea;

    public RentableHouse(int pricePerMonth, int area, int floorsNumber, int bedroomsAmount,
                         int roomsAmount, int peopleAmount, boolean isKitchenExist) {
        super(pricePerMonth, area, floorsNumber, bedroomsAmount, roomsAmount, peopleAmount, isKitchenExist);
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

    public void setGarageExist(boolean garageExist) {
        isGarageExist = garageExist;
    }

    public void setOutsideArea(int outsideArea) {
        this.outsideArea = outsideArea;
    }
}
