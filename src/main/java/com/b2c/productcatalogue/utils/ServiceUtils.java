package com.b2c.productcatalogue.utils;

import java.util.regex.Pattern;

public class ServiceUtils {

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String str){

        if(str == null){
            return false;
        } else{
            return pattern.matcher(str).matches();
        }

    }
}
