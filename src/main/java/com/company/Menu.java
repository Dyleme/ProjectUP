package com.company;

import Dao.AbstractDao;
import Dao.CsvDao;
import Dao.JsonDao;
import Dao.XmlDao;
import Renatble.*;
import Sorters.AbstractSorter;
import Sorters.BestOfferSorter;
import Sorters.PriceSorter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scanner;
    List list;
    Type type;
    Class clazz;
    AbstractDao dao;

    private enum Type{
        Xml,
        Json,
        Csv
    }
    void start(){
        scanner = new Scanner(System.in);
        type = null;
        while(type == null) {
            System.out.println("Choose type of files");
            System.out.println("1) Xml");
            System.out.println("2) Json");
            System.out.println("3) Csv");
            int temp = scanner.nextInt();

            switch (temp){
                case 1:
                    type = Type.Xml;
                    break;
                case 2:
                    type = Type.Json;
                    break;
                case 3:
                    type = Type.Csv;
                    break;
            }
        }

        clazz = null;
        while(clazz == null) {
            System.out.println("Choose type of rentable places");
            System.out.println("0) Office");
            System.out.println("1) Flat");
            System.out.println("2) House");
            int temp = scanner.nextInt();
            switch (temp){
                case 0:
                    clazz = RentableOffice.class;
                    break;
                case 1:
                    clazz = RentableFlat.class;
                    break;
                case 2:
                    clazz = RentableHouse.class;
                    break;
            }
        }

        boolean areYouDoingSomething = false;
        while(!areYouDoingSomething){
            System.out.println("Choose what you want to do");
            System.out.println("1) Sort File");
            System.out.println("2) Make File");
            int a = scanner.nextInt();
            switch (a){
                case 1:
                    sortFiles();
                    areYouDoingSomething = true;
                    break;
                case 2:
                    makeFile();
                    areYouDoingSomething = true;
                    break;
            }
        }




    }

    private void makeFile() {
        String outputFileName = null;
        while (outputFileName == null){
            System.out.println("Write output file name");
            outputFileName = scanner.next();
        }
        initDao(outputFileName);
        ArrayList<Rentable> list = new ArrayList<>();
        if (clazz.equals(RentableOffice.class)) {
            list.add(new RentableOffice(new Address("Belarus", "Minsk", "Minsk", "Filimonova", "55")
                    ,100,20,3, OfficeType.OPEN_SPACE,5,6,8));
            list.add(new RentableOffice(new Address("Belarus", "Moskva", "Moskva", "Tverkaya", "12")
                    ,1000,120,43, OfficeType.OPEN_SPACE,45,16,18));
            list.add(new RentableOffice(new Address("Belarus", "Minsk", "Minsk", "PVT", "01010101")
                    ,100,20,3, OfficeType.OPEN_SPACE,10,21,2));
            list.add(new RentableOffice(new Address("Belarus", "Mogilev", "Minsk", "Panama", "515")
                    ,12,222,1, OfficeType.ROOMS,12,32,3));
        } else if(clazz.equals(RentableHouse.class)){
            list.add(new RentableHouse(new Address("Belarus", "Minsk", "Minsk", "Filimonova", "55"),
                    100,100,1001,100,100,100,true));
            list.add(new RentableHouse(new Address("Belarus", "Minsk", "Minsk", "Malberta", "12"),
             50, 60 ,12,144,144,54,true));
            list.add(new RentableHouse(new Address("Belarus", "Minsk", "Minsk", "Prospect Nezavisiomsit", "92"),
            75, 53, 53,23, 534,43,true));
        } else if(clazz.equals(RentableFlat.class)){
            list.add(new RentableFlat(new Address("Belarus", "Mogilew", "Mogilew", "Howl", "55"),
                    23, 23, 543, 43, 43, 43,false,43,543, true));

            list.add(new RentableFlat(new Address("Russia", "Sankt-Petersburg", "Sankt-Petersburg", "Lenina", "23"),
32,42,42,16,43,76, true, 2, 65,true));

            list.add(new RentableFlat(new Address("Belarus", "Minsk", "Minsk", "Forecast", "093"),
        94,49,39,20,04,03,false, 2,1,true));
        }
        try {
            dao.write(list);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void sortFiles() {
        String inputFileName = null;
        while (inputFileName == null){
            System.out.println("Write input file name");
            inputFileName = scanner.next();
        }


        initDao(inputFileName);

        try {
            list = dao.read();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        String outputFileName = null;
        while (outputFileName == null){
            System.out.println("Write output file name");
            outputFileName = scanner.next();
        }

        int operation = -1;
        dao.setFileName(outputFileName);
        while (operation  != -2){
            System.out.println("Choose operation:");
            System.out.println("0) Sort by price");
            System.out.println("1) Sort by best offer");
            System.out.println("-2) Quit");
            operation = scanner.nextInt();
            AbstractSorter<Rentable> sorter;
            switch (operation){
                case 0:
                    sorter = new PriceSorter<>(list);
                    sorter.sort();
                    sorter.print(dao);
                    break;
                case 1:
                    sorter = new BestOfferSorter<>(list);
                    sorter.sort();
                    sorter.print(dao);
                    break;
            }
        }
    }

    private void initDao(String fileName) {
        dao = null;
        switch (type) {
            case Xml:
                dao = new XmlDao(fileName);
                break;
            case Json:
                dao = new JsonDao(fileName, clazz);
                break;
            case Csv:
                dao = new CsvDao(fileName, clazz);
                break;
        }
    }
}
