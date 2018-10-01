package com.justkaira.util;

public class NumberUtil {


    public static double getNumberValue(String val) {
        try {
            return Double.parseDouble(val);
        }catch(NumberFormatException e){
            return 0;
        }
    }


}
