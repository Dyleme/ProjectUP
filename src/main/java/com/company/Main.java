package com.company;


import Dao.XmlDao;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<RentableOffice> list = new ArrayList<RentableOffice>();
//        JsonDao jsonConverter = new JsonDao<RentableFlat>("file.json");

        XmlDao xmlConverter = new XmlDao<RentableOffice>("file.xml");
        list.add(new RentableOffice(1,2,3,OfficeType.OPEN_SPACE,5,6,8));
        list.add(new RentableOffice(2,2,3,OfficeType.ROOMS,5,6,8));
        list.add(new RentableOffice(3,2,3,OfficeType.OPEN_SPACE,5,6,8));
        list.add(new RentableOffice(4,2,3,OfficeType.ROOMS,5,6,8));
//
//        jsonConverter.write(list);
//        List<RentableOffice> offices = jsonConverter.read();\
        xmlConverter.write(list);
        return;
    }
}
