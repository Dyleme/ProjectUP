package Dao;

import Renatble.Rentable;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({Rentable.class})
class Wrapper<T>{
    private final List<T> items;

    public Wrapper() {
        this.items = new ArrayList<T>();
    }

    public Wrapper(List<T> items){
        this.items = items;
    }
    @XmlAnyElement(lax=true)
    public List<T> getItems(){
        return items;
    }
}