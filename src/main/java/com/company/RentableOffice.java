package com .company;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

enum OfficeType{
    OPEN_SPACE,
    ROOMS
}

@XmlRootElement(name = "RentableOffice")
@XmlSeeAlso({Rentable.class})
public class RentableOffice extends Rentable {

    @JsonProperty("OfficeType")
    protected OfficeType type;

    @JsonProperty("AmountOfPlaces")
    protected int placesAmount;

    @JsonProperty("DistanceMetro")
    protected int distanceFromMetro;

    @JsonProperty("ConferenceRoom")
    protected int amountOfConferenceRoom;

    public RentableOffice(Address address, int pricePerMonth, int area, int floorsNumber, OfficeType type,
                          int placesAmount, int distanceFromMetro, int amountOfConferenceRoom) {
        super(address, pricePerMonth, area, floorsNumber);
        this.type = type;
        this.placesAmount = placesAmount;
        this.distanceFromMetro = distanceFromMetro;
        this.amountOfConferenceRoom = amountOfConferenceRoom;
    }

    public RentableOffice() {
        super();
    }

    @XmlElement()
    public OfficeType getType() {
        return type;
    }

    @XmlElement()
    public int getPlacesAmount() {
        return placesAmount;
    }

    @XmlElement()
    public int getDistanceFromMetro() {
        return distanceFromMetro;
    }

    @XmlElement()
    public int getAmountOfConferenceRoom() {
        return amountOfConferenceRoom;
    }

    public String getTypeAsString(){return type.toString();}

    public void setType(OfficeType type) {
        this.type = type;
    }

    public void setPlacesAmount(int placesAmount) {
        this.placesAmount = placesAmount;
    }

    public void setDistanceFromMetro(int distanceFromMetro) {
        this.distanceFromMetro = distanceFromMetro;
    }

    public void setAmountOfConferenceRoom(int amountOfConferenceRoom) {
        this.amountOfConferenceRoom = amountOfConferenceRoom;
    }
}
