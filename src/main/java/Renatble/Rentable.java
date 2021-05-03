package Renatble;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;


@XmlRootElement(name = "rentable")
@XmlSeeAlso({RentableOffice.class, RentableForLiving.class})
public abstract class Rentable {

    private static int next_id;

    @JsonProperty("Id")
    protected int id;

    @JsonProperty("Address")
    protected Address address;

    @JsonProperty("Price")
    protected int pricePerMonth;

    @JsonProperty("Area")
    protected int area;

    @JsonProperty("Floors")
    protected int floorsNumber;

    public Rentable(Address address, int pricePerMonth, int area, int floorsNumber) {
        this.id = next_id;
        next_id++;
        this.address = address;
        this.pricePerMonth = pricePerMonth;
        this.area = area;
        this.floorsNumber = floorsNumber;
    }

    public Rentable() {
        super();
    }

    @XmlElement()
    public int getId() {
        return id;
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

    private void setId(int id){ this.id = id; }

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

