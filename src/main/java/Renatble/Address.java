package Renatble;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Address")
public class Address {

    @JsonProperty("Country")
    protected String country;

    @JsonProperty("Region")
    protected String region;

    @JsonProperty("City")
    protected String city;

    @JsonProperty("Street")
    protected String street;

    @JsonProperty("HouseNumber")
    protected String houseNumber;

    public Address() {}

    public Address(String country, String region, String city, String street, String houseNumber) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @XmlElement()
    public String getCountry() {
        return country;
    }

    @XmlElement()
    public String getRegion() {
        return region;
    }

    @XmlElement()
    public String getCity() {
        return city;
    }

    @XmlElement()
    public String getStreet() {
        return street;
    }

    @XmlElement()
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
