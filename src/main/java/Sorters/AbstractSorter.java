package Sorters;

import Dao.AbstractDao;
import Renatble.Rentable;

import java.io.IOException;
import java.util.List;

public abstract class AbstractSorter<T extends Rentable> {
    List<T> list;

    abstract public void sort();

    public void print(AbstractDao dao){
        try {
            dao.write(list);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public AbstractSorter(List<T> list) {
        this.list = list;
    }
}
