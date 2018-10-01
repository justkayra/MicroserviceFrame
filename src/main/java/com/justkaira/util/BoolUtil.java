package com.justkaira.util;

public class BoolUtil {


    public static boolean getBooleanValue(double val) {
        if (val == 0){
            return false;
        }else{
            return true;
        }
    }

    public static boolean getBooleanValue(String val) {
        if (val.equals("1") || val.equalsIgnoreCase("true")){
            return true;
        }else{
            return false;
        }
    }

}
