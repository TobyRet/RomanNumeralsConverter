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
        table.put(5, "V");
        table.put(10, "X");
        table.put(50, "L");
    }

    public String convert(int number) {
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
        };
        return romanNumeral;
    }
}
