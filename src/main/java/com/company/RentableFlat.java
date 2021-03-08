package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "rentableFlat")
public class RentableFlat extends RentableForLiving {
    @JsonProperty("DistanceMetro")
    protected int distanceFromMetro;

    @JsonProperty("Floor")
    protected int floor;

    @JsonProperty("IsElevator")
    protected boolean isElevatorExist;

    public RentableFlat(int pricePerMonth, int area, int floorsNumber, int bedroomsAmount, int roomsAmount, int peopleAmount, boolean isKitchenExist, int distanceFromMetro, int floor, boolean isElevatorExist) {
        super(pricePerMonth, area, floorsNumber, bedroomsAmount, roomsAmount, peopleAmount, isKitchenExist);
        this.distanceFromMetro = distanceFromMetro;
        this.floor = floor;
        this.isElevatorExist = isElevatorExist;
    }

    public RentableFlat() {
        super();
    }

    public int getDistanceFromMetro() {
        return distanceFromMetro;
    }

    public int getFloor() {
        return floor;
    }

    public boolean getIsElevatorExist() {
        return isElevatorExist;
    }

    public void setDistanceFromMetro(int distanceFromMetro) {
        this.distanceFromMetro = distanceFromMetro;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setElevatorExist(boolean elevatorExist) {
        isElevatorExist = elevatorExist;
    }
}
