package Sorters;

import Renatble.Rentable;

import java.util.Comparator;
import java.util.List;

public class PriceSorter<T extends Rentable> extends AbstractSorter<T> {

    @Override
    public void sort() {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getPricePerMonth() - o2.getPricePerMonth();
            }
        });
    }


    public PriceSorter(List<T> list) {
        super(list);
    }
}
