package Dao;

import java.io.IOException;
import java.util.List;

public abstract class AbstractDao <T>{

    protected String fileName;

    public void write(List<T> list) throws IOException {}

    public List<T> read() throws IOException {
        return null;
    };

    public AbstractDao(String fileName){
        this.fileName = fileName;
    }

}
