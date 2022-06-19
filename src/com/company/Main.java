package com.company;

import java.awt.List;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ExeptionValue {
        Calculate calculate = new Calculate();
        while (true) {
try{
            String value = calculate.setValue();

            String v = String.valueOf(value.charAt(0));
            if (v.matches("[a-zA-Z]{1}")) {

                String[][] values = new String[][]{calculate.takeTheValue(value)};

                int a = 0;
                switch (values[0][2]) {
                    case "/":
                        a = calculate.takeAnArabicNumeral(values[0][0]) / calculate.takeAnArabicNumeral(values[0][1]);
                        break;
                    case "*":
                        a = calculate.takeAnArabicNumeral(values[0][0]) * calculate.takeAnArabicNumeral(values[0][1]);
                        break;
                    case "-":
                        a = calculate.takeAnArabicNumeral(values[0][0]) - calculate.takeAnArabicNumeral(values[0][1]);
                        break;
                    case "+":
                        a = calculate.takeAnArabicNumeral(values[0][0]) + calculate.takeAnArabicNumeral(values[0][1]);
                        break;
                }

                System.out.println(calculate.takeAnRomanNumeral(a));

            } else if (v.matches("^[0-9]*$")) {

                int a = 0;
                int[][] array = new int[][]{calculate.takeTheValueArabic(value)};
                switch (array[0][2]) {
                    case 1 -> a = array[0][0] / array[0][1];
                    case 2 -> a = array[0][0] * array[0][1];
                    case 3 -> a = array[0][0] - array[0][1];
                    case 4 -> a = array[0][0] + array[0][1];
                }
                System.out.println(a);
            }
        }catch (NullPointerException e){
    System.out.println(e.getMessage());
        }
        }
    }
}
