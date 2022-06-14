package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Напишите только римские цифры !");
            String romanNumber = scanner.nextLine().toUpperCase(Locale.ROOT);
            String e = "";
            String v = "";
            char s = ' ';
            for (int i = 0; i < romanNumber.length(); i++) {
                if (romanNumber.charAt(i) == '/' || romanNumber.charAt(i) == '*' || romanNumber.charAt(i) == '+' || romanNumber.charAt(i) == '-') {
                    s = romanNumber.charAt(i);
                    e = romanNumber.substring(0, i);
                    v = romanNumber.substring(i + 1);
                }
            }
            int a = 0;
            if (s == '/') {
                a = romanInt(e) / romanInt(v);
            } else if (s == '*') {
                a = romanInt(e) * romanInt(v);
            } else if (s == '-') {
                a = romanInt(e) - romanInt(v);
            } else if (s == '+') {
                a = romanInt(e) + romanInt(v);
            } else {
                System.out.println("У нас нету такое оператор !");
            }

            System.out.println(intRoman(a));
            System.out.println();
        }

    }

    public static int romanInt(String s) {

        int output = 0;

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        if (s.length() == 0) return 0;
        if (s.length() == 1) return map.get(String.valueOf(s.charAt(0)));

        for (int i = 0; i < (s.length() - 1); i++) {
            if (map.get(String.valueOf(s.charAt(i))) >= map.get(String.valueOf(s.charAt(i + 1)))) {
                output = output + map.get(String.valueOf(s.charAt(i)));
            } else {
                output = output - map.get(String.valueOf(s.charAt(i)));
            }

        }
        output = output + map.get(String.valueOf(s.charAt(s.length() - 1)));
        return output;
    }


    public static String intRoman(int num) {
        return List.of("", "M", "MM", "MMM").get(num / 1000) +
                List.of("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM").get(num / 100 % 10) +
                List.of("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC").get(num / 10 % 10) +
                List.of("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX").get(num % 10);
    }

}
