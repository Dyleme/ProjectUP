package Renatble;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import validator.CapitalLetterValidator;
import validator.NumberValidator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(!CapitalLetterValidator.isValid(country)) {
            country = makeFirstLetterCapitall(country);
        }
        if(!CapitalLetterValidator.isValid(region)){
            region = makeFirstLetterCapitall(region);
        }
        if(!CapitalLetterValidator.isValid(city)){
            city = makeFirstLetterCapitall(city);
        }
        if(!CapitalLetterValidator.isValid(street)){
            street = makeFirstLetterCapitall(street);
        }
        if (!NumberValidator.isValid(houseNumber)) {
            Pattern pattern = Pattern.compile("[1-9][0-9]*");
            Matcher matcher = pattern.matcher(houseNumber);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                houseNumber = houseNumber.substring(start, end);
            } else {
                houseNumber = "0";
            }
        }
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @NotNull
    private String makeFirstLetterCapitall(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
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
