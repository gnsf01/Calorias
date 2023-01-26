package com.gnsfilho01.calorias;

import static java.lang.Double.parseDouble;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test {
    public static void main (String[] args){

//        System.out.println(Math.ceil(6.1));
//        System.out.println(Math.floor(6.9));
//        System.out.println(Math.round(6.5));
//
//
//        int a = 1;
//        double b = 2.3;
//        String c = "vlsdafgj";
//
//       double b2 = 1.5;
//       Integer a1 = 4;
////       a1.toString();
//
//        System.out.println(String.valueOf(a1));
//        System.out.println(Integer.valueOf(a1));
//
//        Integer hh = (int)b2;
//        System.out.println(hh);


        String campo1 = "4",
               campo2 = "7",
               campo3 = "5";

        Double totalCal = (parseDouble(campo1) /
                parseDouble(campo2) *
                parseDouble(campo3));

        System.out.println(totalCal.toString());
        System.out.println(totalCal.toString().substring(0,4));


        DecimalFormat df = new DecimalFormat(".00");

        df.setRoundingMode(RoundingMode.DOWN);

        System.out.println(df.format(totalCal));


    }
}
