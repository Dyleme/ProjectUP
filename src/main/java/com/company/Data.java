package com.company;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "array")
public class Data {
    ArrayList<Rentable> array;

    @XmlElement()
    public ArrayList<Rentable> getArray() {
        return array;
    }

    Data(){
        array = new ArrayList<>();
    }
}
