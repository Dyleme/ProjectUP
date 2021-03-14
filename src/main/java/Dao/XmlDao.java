package Dao;

import com.company.RentableOffice;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
class Wrapper<T>{
    private final List<T> items;

    public Wrapper() {
        this.items = new ArrayList<T>();
    }

    public Wrapper(List<T> items){
        this.items = items;
    }
    @XmlElement()
    public List<T> getItems(){
        return items;
    }
}


public class XmlDao<T> extends AbstractDao<T> {


    public static void writeToXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(RentableOffice.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        mar.marshal(office, new File("book.xml"));
    }

    public static RentableOffice readFromXML() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(RentableOffice.class);
        return (RentableOffice) context.createUnmarshaller()
                .unmarshal(new FileReader("book.xml"));
    }

    @Override
    public void write(List<T> list) throws IOException {
        Wrapper<T> wrapper = new Wrapper<>(list);
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(wrapper, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void write(T objecct) throws IOException {
//        try {
//            JAXBContext context = JAXBContext.newInstance(objecct.getClass());
//
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//
//            Marshaller mar = context.createMarshaller();
//            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            mar.marshal(objecct, new File(fileName));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }

    public XmlDao(String fileName){
        super(fileName);
    }
}
