package org.talamona.patternsmockup.adapter.adaptee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 4/29/13
 * Time: 10:32 AM
 */

public class NumberSorter {
    public List<Integer> sort(List<Integer> numbers){
        Collections.sort(numbers);
        return new ArrayList<Integer>(numbers);
    }
}
