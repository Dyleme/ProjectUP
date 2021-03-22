package com.company;


import Dao.CsvDao;
import Dao.JsonDao;
import Dao.XmlDao;
import Renatble.Address;
import Renatble.OfficeType;
import Renatble.RentableOffice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;


public class Main {



    public static void main(String[] args) throws IOException {

        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("C:\\programs\\UP\\Project\\src\\main\\java\\logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        ArrayList<RentableOffice> list = new ArrayList<RentableOffice>();
//        JsonDao jsonConverter = new JsonDao<RentableFlat>("file.json");

        XmlDao xmlDao = new XmlDao<RentableOffice>("file.xml");
        JsonDao jsonDao = new JsonDao<RentableOffice>("file.json", RentableOffice.class);
        CsvDao csvDao = new CsvDao<RentableOffice>("file.csv", RentableOffice.class);
        Address address = new Address("belarus", "insk", "finsk", "Filimonova -dsjhlfk", "sdlkhg 55  hlksdajfg");
        list.add(new RentableOffice(address,1,2,3, OfficeType.OPEN_SPACE,5,6,8));
        list.add(new RentableOffice(address,2,2,3,OfficeType.ROOMS,5,6, 8));
        list.add(new RentableOffice(address,3,2,3,OfficeType.OPEN_SPACE,5,6,8));
        list.add(new RentableOffice(address,4,2,3,OfficeType.ROOMS,5,6,8));
//
//        List<RentableOffice> offices = jsonConverter.read();\
//        xmlDao.write(list);
        jsonDao.write(list);
//        csvDao.write(list);
//        List offices = xmlDao.read();
//        List jsonOffices = jsonDao.read();
        List csvOffices = csvDao.read();
//        csvDao.write(list);
//        Menu menu = new Menu();
//        menu.start();
        return;
    }
}
