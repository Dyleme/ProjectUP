package Dao;

import com.company.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvDao<T> extends AbstractDao<T>{

    private final Class<T> tClass;
    private PrintWriter printWriter;
    private Scanner scanner;
    private Scanner lineScanner;

    public CsvDao(String fileName, Class<T> clazz) {
        super(fileName);
        tClass = clazz;
    }

    protected void writeRentable(Rentable rentable){

        writeAddres(rentable.getAddress());
        printWriter.print(rentable.getPricePerMonth());
        printWriter.print(';');
        printWriter.print(rentable.getArea());
        printWriter.print(';');
        printWriter.print(rentable.getFloorsNumber());
        printWriter.print(';');

        if(tClass == RentableOffice.class){
            writeRentableOffice((RentableOffice) rentable);
        } else if (tClass == RentableHouse.class){
            writeRentableHouse((RentableHouse) rentable);
        } else if (tClass == com.company.RentableFlat.class){
            writeRentableFlat((com.company.RentableFlat) rentable);
        }
        printWriter.print('\n');
    }

    protected void writeAddres(Address address){
        printWriter.print(address.getCountry() + ';');
        printWriter.print(address.getRegion() + ';');
        printWriter.print(address.getCity() + ';');
        printWriter.print(address.getStreet() + ';');
        printWriter.print(address.getHouseNumber() + ';');
    }

    private void writeRentableOffice(RentableOffice rentableOffice) {
        printWriter.print(rentableOffice.getTypeAsString());
        printWriter.print(';');
        printWriter.print(rentableOffice.getPlacesAmount());
        printWriter.print(';');
        printWriter.print(rentableOffice.getDistanceFromMetro());
        printWriter.print(';');
        printWriter.print(rentableOffice.getAmountOfConferenceRoom());
        printWriter.print(';');
    }

    private void writeRentableHouse(RentableHouse rentableHouse){
        writeRentableForLiving(rentableHouse);
        printWriter.print(rentableHouse.getIsGarageExist());
        printWriter.print(';');
        printWriter.print(rentableHouse.getOutsideArea());
        printWriter.print(';');
    }

    private void writeRentableFlat(com.company.RentableFlat rentableFlat){
        writeRentableForLiving(rentableFlat);
        printWriter.print(rentableFlat.getDistanceFromMetro());
        printWriter.print(';');
        printWriter.print(rentableFlat.getFloor());
        printWriter.print(';');
        printWriter.print(rentableFlat.getIsElevatorExist());
        printWriter.print(';');
    }

    private void writeRentableForLiving(RentableForLiving rentableForLiving){
        printWriter.print(rentableForLiving.getBedroomsAmount());
        printWriter.print(';');
        printWriter.print(rentableForLiving.getRoomsAmount());
        printWriter.print(';');
        printWriter.print(rentableForLiving.getPeopleAmount());
        printWriter.print(';');
        printWriter.print(rentableForLiving.getIsKitchenExist());
        printWriter.print(';');
    }






    @Override
    public void write(List<T> list) throws IOException {
        printWriter = new PrintWriter(new File(fileName));
        for(T obj : list){
            writeRentable((Rentable) obj);
        }
        printWriter.close();
    }

    @Override
    public List<T> read() throws IOException {
        List list = new ArrayList<T>();
        scanner = new Scanner(new File(fileName));
        AbstractReader<T> reader = null;
        if(tClass == RentableOffice.class){
            reader = new OfficeReader<>();
        } else if (tClass == RentableHouse.class){
            reader = new HouseReader<>();
        } else if (tClass == com.company.RentableFlat.class){
            reader = new FlatReader<>();
        } else {
        }
        while(scanner.hasNextLine()){
            lineScanner = new Scanner(scanner.nextLine());
            lineScanner.useDelimiter(";\n");
            list.add(reader.readClass());
        }
        return list;
    }

    abstract class AbstractReader<T>{
        T readClass(){
            return null;
        }
    }

    class OfficeReader<T> extends AbstractReader<T>{
        @Override
        T readClass() {
            RentableOffice rentableOffice = new RentableOffice();
            rentableOffice.setAddress(readAddress());
            return (T) rentableOffice;
        }
    }

    class HouseReader<T> extends AbstractReader<T>{
        @Override
        T readClass() {
            RentableHouse rentableHouse = new RentableHouse();
            rentableHouse.setAddress(readAddress());
            return (T) rentableHouse;
        }
    }

    class FlatReader<T> extends AbstractReader<T> {
        @Override
        T readClass() {
            com.company.RentableFlat rentableFlat = new com.company.RentableFlat();
            rentableFlat.setAddress(readAddress());
            return (T) rentableFlat;
        }
    }

    private Address readAddress(){
        Address address = new Address();
        address.setCountry(lineScanner.next());
        address.setRegion(lineScanner.next());
        address.setCity(lineScanner.next());
        address.setStreet(lineScanner.next());
        address.setHouseNumber(lineScanner.next());
        return address;
    }
}
