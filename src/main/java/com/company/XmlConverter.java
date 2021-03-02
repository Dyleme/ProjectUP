package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class XmlConverter extends Converter{
    public static void writeToXml() throws JAXBException {
        RentableOffice office = new RentableOffice(1,2,3,OfficeType.OPEN_SPACE,5,6,7);
        JAXBContext context = JAXBContext.newInstance(RentableOffice.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(office, new File("book.xml"));
    }

    public static RentableOffice readFromXML() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(RentableOffice.class);
        return (RentableOffice) context.createUnmarshaller()
                .unmarshal(new FileReader("book.xml"));
    }

    @Override
    public void addToFile(List<Rentable> list) throws IOException {
        super.addToFile(list);
    }

    @Override
    public void addToFile(Rentable rentable) throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(rentable.getClass());

            Unmarshaller unmarshaller = context.createUnmarshaller();

            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(rentable, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    XmlConverter(String fileName){
        super(fileName);
    }
}
