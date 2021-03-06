package Renatble;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.UUID;


@XmlRootElement(name = "rentable")
@XmlSeeAlso({RentableOffice.class, RentableForLiving.class})
public abstract class Rentable {


    @JsonProperty("UUID")
    protected String uuid;

    @JsonProperty("Address")
    protected Address address;

    @JsonProperty("Price")
    protected int pricePerMonth;

    @JsonProperty("Area")
    protected int area;

    @JsonProperty("Floors")
    protected int floorsNumber;

    public Rentable(Address address, int pricePerMonth, int area, int floorsNumber) {
        this.uuid = UUID.randomUUID().toString();
        this.address = address;
        this.pricePerMonth = pricePerMonth;
        this.area = area;
        this.floorsNumber = floorsNumber;
    }

    public Rentable() {
        super();
    }

    @XmlElement()
    public String getUuid() {
        return uuid;
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

    @XmlElement()
    public Address getAddress() {
        return address;
    }

    private void setUuid(String uuid){ this.uuid = uuid; }

    public void setAddress(Address address) {
        this.address = address;
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

