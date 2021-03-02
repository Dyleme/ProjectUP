package com.company;

import java.io.IOException;
import java.util.List;

public abstract class Converter {

    protected String fileName;

    public void addToFile(List<Rentable> list) throws IOException {}

    public void addToFile(Rentable rentable) throws IOException {}

    public List<Rentable> getFromFile() throws IOException {
        return null;
    };

    Converter(String fileName){
        this.fileName = fileName;
    }

}
