package com.company;


import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Rentable> list = new ArrayList<Rentable>();
        list.add(new RentableFlat(1,2,3,4,5,6,false,8,9,false));
//        list.add(new RentableOffice(1,2,3,OfficeType.OPEN_SPACE,5,6,7));
//        list.add(new RentableHouse(1,2,3,4,5,6,false));

        JsonConverter jsonConverter = new JsonConverter("file.json");
        XmlConverter xmlConverter = new XmlConverter("file.xml");
//        jsonConverter.addToFile(list);
//        jsonConverter.addToFile(new RentableFlat(12,21,13,4,5,6,false,8,9,false));
        xmlConverter.addToFile(new RentableFlat(12,21,13,4,5,6,false,8,9,false));
//        List<Rentable> fromJson = Converter.readFromJson();
//        fromJson.get(0);
//        try {
//            Converter.writeToXml();
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
        RentableOffice office = null;
        try {
            office = XmlConverter.readFromXML();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        list.add(new RentableFlat(2,3,4,5,6,7,false, 8,9,false));
        list.add(new RentableFlat(2,3,4,5,6,7,false, 8,9,false));
        list.add(new RentableFlat(2,3,4,5,6,7,false, 8,9,false));
        list.add(new RentableFlat(2,10,4,5,6,7,false, 8,9,false));
        list.sort(new Comparator<Rentable>() {
            @Override
            public int compare(Rentable o1, Rentable o2) {
                return (o2.pricePerMonth / o2.area) - (o1.pricePerMonth / o1.area);
            }
        });
        return;
    }
}
