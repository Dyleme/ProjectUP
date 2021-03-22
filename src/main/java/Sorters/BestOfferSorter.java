package Sorters;

import Renatble.Rentable;

import java.util.Comparator;
import java.util.List;

public class BestOfferSorter<T extends Rentable> extends AbstractSorter<T>{

    @Override
    public void sort() {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                Double value1 = (double) o1.getPricePerMonth() / o1.getArea();
                Double value2 = (double) o2.getPricePerMonth() / o2.getArea();
                return value1.compareTo(value2);
            }
        });
    }


    public BestOfferSorter(List<T> list) {
        super(list);
    }
}
