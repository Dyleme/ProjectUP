package Dao;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractDao <T>{

    protected static Logger log = Logger.getLogger(AbstractDao.class.getName());

    protected String fileName;

    public void write(List<T> list) throws IOException {}

    public List<T> read() throws IOException {
        return null;
    };

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public AbstractDao(String fileName){
        this.fileName = fileName;
    }

}
