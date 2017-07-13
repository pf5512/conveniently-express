package com.neng.utils;


import lombok.extern.slf4j.Slf4j;


import javax.xml.bind.DatatypeConverter;

@Slf4j
public class CustomValidator {

    public static boolean hasEmpty(String...strings){
        for (String str:strings){
            if (str==null||str.isEmpty()){
                return true;
            }
        }
        return false;
    }
    public static boolean hasNull(Object...objects){
        for (Object object:objects){
            if(object==null){
                return true;
            }
        }
        return false;
    }



}
