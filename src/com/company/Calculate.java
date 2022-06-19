package com.company;

import java.util.*;

public class Calculate {


    public String setValue() throws ExeptionValue {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine().toUpperCase(Locale.ROOT);
        if(value.length()==0||value.equals(null)){
            throw new ExeptionValue("Вы ничего не ввели");
        }
        try {
            if (!value.contains("/") && !value.contains("*") && !value.contains("-") && !value.contains("+")) {
                throw new ExeptionValue("Неправильно ввели математические данные !");
            }

        } catch (ExeptionValue er) {
            System.out.println(er.getMessage());
        }

        return value;

    }

    public String[] takeTheValue(String romanNumber) {
        String[] value = new String[3];
        try{
        for (int i = 0; i < romanNumber.length(); i++) {
            if (!romanNumber.contains("/") && !romanNumber.contains("*") && !romanNumber.contains("-") && !romanNumber.contains("+")){
                throw new RuntimeException("Вы не указали математические операции !");
            }
            if (romanNumber.charAt(i) == '/' ||
                    romanNumber.charAt(i) == '*' ||
                    romanNumber.charAt(i) == '+' ||
                    romanNumber.charAt(i) == '-') {

                value[0] = romanNumber.substring(0, i);
                value[1] = romanNumber.substring(i + 1);
                value[2] = String.valueOf(romanNumber.charAt(i));
            }
        }

    }catch (NullPointerException e){
            System.out.println("Укажите правильное значение !");
        }catch (RuntimeException e){
            e.getMessage();
        }
        return value;
    }

    public int takeAnArabicNumeral(String s) {
        int output = 0;
     try {
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
     }catch (NullPointerException e){
         System.out.println("Укажите правильное значение !");
     }
        return output;

    }

    public String takeAnRomanNumeral(int num) {
        return List.of("", "M", "MM", "MMM").get(num / 1000) +
                List.of("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM").get(num / 100 % 10) +
                List.of("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC").get(num / 10 % 10) +
                List.of("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX").get(num % 10);

    }

    public int[] takeTheValueArabic(String romanNumber) {
        int[] values = new int[3];
        try {
            for (int i = 0; i < romanNumber.length(); i++) {
                if (!romanNumber.contains("/") && !romanNumber.contains("*") && !romanNumber.contains("-") && !romanNumber.contains("+")) {
                    throw new RuntimeException("Вы не указали математические операции !");
                }
                if (romanNumber.charAt(i) == '/' ||
                        romanNumber.charAt(i) == '*' ||
                        romanNumber.charAt(i) == '+' ||
                        romanNumber.charAt(i) == '-') {

                    values[0] = Integer.parseInt(romanNumber.substring(0, i));
                    values[1] = Integer.parseInt(romanNumber.substring(i + 1));
                    switch (romanNumber.charAt(i)) {
                        case '/' -> values[2] = 1;
                        case '*' -> values[2] = 2;
                        case '-' -> values[2] = 3;
                        case '+' -> values[2] = 4;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Укажите правильное значение !");
        } catch (RuntimeException e) {
            e.getMessage();
        }

            return values;
        }
    }

