package Dao;

import com.company.Rentable;

import java.io.IOException;
import java.util.List;

public abstract class AbstractDao {

    protected String fileName;

    public void addToFile(List<Rentable> list) throws IOException {}

    public void addToFile(Rentable rentable) throws IOException {}

    public List<Rentable> getFromFile() throws IOException {
        return null;
    };

    public AbstractDao(String fileName){
        this.fileName = fileName;
    }

}
