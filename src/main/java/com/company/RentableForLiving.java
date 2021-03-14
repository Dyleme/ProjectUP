package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "rentableForLiving")
@XmlSeeAlso({RentableFlat.class, RentableHouse.class})
public abstract class RentableForLiving extends Rentable {

    @JsonProperty("BedroomsAmount")
    protected int bedroomsAmount;

    @JsonProperty("RoomsAmount")
    protected int roomsAmount;

    @JsonProperty("PeopleAmount")
    protected int peopleAmount;

    @JsonProperty("isKitchenExist")
    protected boolean isKitchenExist;

    public RentableForLiving(int pricePerMonth, int area, int floorsNumber, int bedroomsAmount,
                             int roomsAmount, int peopleAmount, boolean isKitchenExist) {
        super(pricePerMonth, area, floorsNumber);
        this.bedroomsAmount = bedroomsAmount;
        this.roomsAmount = roomsAmount;
        this.peopleAmount = peopleAmount;
        this.isKitchenExist = isKitchenExist;
    }

    public RentableForLiving() {
        super();
    }

    @XmlElement()
    public int getBedroomsAmount() {
        return bedroomsAmount;
    }

    @XmlElement()
    public int getRoomsAmount() {
        return roomsAmount;
    }

    @XmlElement()
    public int getPeopleAmount() {
        return peopleAmount;
    }

    @XmlElement(name = "isKitchenExist" )
    public boolean getIsKitchenExist() {
        return isKitchenExist;
    }

    public void setBedroomsAmount(int bedroomsAmount) {
        this.bedroomsAmount = bedroomsAmount;
    }

    public void setRoomsAmount(int roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public void setKitchenExist(boolean kitchenExist) {
        isKitchenExist = kitchenExist;
    }
}

