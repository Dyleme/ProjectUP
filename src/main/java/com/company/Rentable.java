package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "rentable")
public abstract class Rentable {


    @JsonProperty("Price")
    protected int pricePerMonth;

    @JsonProperty("Area")
    protected int area;

    @JsonProperty("Floors")
    protected int floorsNumber;

    public Rentable(int pricePerMonth, int area, int floorsNumber) {
        this.pricePerMonth = pricePerMonth;
        this.area = area;
        this.floorsNumber = floorsNumber;
    }

    public Rentable() {
        super();
    }

    @XmlElement()
    public int getPricePerMonth() {
        return pricePerMonth;
    }

    @XmlElement()
    public int getArea() {
        return area;
    }

    @XmlElement()
    public int getFloorsNumber() {
        return floorsNumber;
    }

    public void setPricePerMonth(int pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setFloorsNumber(int floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

