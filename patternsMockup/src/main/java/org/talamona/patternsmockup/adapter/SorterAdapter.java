package org.talamona.patternsmockup.adapter;

import org.talamona.patternsmockup.adapter.adaptee.NumberSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 4/29/13
 * Time: 11:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class SorterAdapter implements Sorter {
    private NumberSorter adaptee;


    public SorterAdapter(){
        this.adaptee = new NumberSorter();

    }

    @Override
    public int[] sort(int[] numbers) {
        List inputValues = new ArrayList();

        for (int i = 0; i < numbers.length; i++){
            inputValues.add(numbers[i]);
        }
        List sortedValues = this.adaptee.sort(inputValues);
        int[] retValue = new int[sortedValues.size()];
        for (int i = 0; i < sortedValues.size(); i++){
            retValue[i] = ((Integer)sortedValues.get(i)).intValue();
        }
        return retValue;
    }
}
