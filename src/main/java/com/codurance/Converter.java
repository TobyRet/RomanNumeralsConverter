/**
 * Created by tobyretallick on 17/08/2014.
 */
package com.codurance;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Converter {
    public static final Map<Integer, String> table;

    static {
        table = new TreeMap<Integer, String>(Collections.reverseOrder());
        table.put(1, "I");
        table.put(4, "IV");
        table.put(5, "V");
        table.put(9, "IX");
        table.put(10, "X");
        table.put(40, "XL");
        table.put(50, "L");
        table.put(90, "XC");
        table.put(100, "C");
        table.put(400, "CD");
        table.put(500, "D");
        table.put(900, "CM");
        table.put(1000, "M");
    }

    public String convert(Integer number) {
        checkArgument(number);
        String romanNumeral = "";
        for (Map.Entry<Integer, String> entry : table.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            Integer factor = number / key;
            Integer remainder = number % key;
            for (int i = 0; i < factor; i++) {
                romanNumeral += value;
            }
            number = remainder;
        }
        return romanNumeral;
    }

    public void checkArgument(Integer number) {
        if(number == null) {
            throw new IllegalArgumentException("You did not enter a number");
        }
    }
}
