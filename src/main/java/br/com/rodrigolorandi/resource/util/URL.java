package br.com.rodrigolorandi.resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

public class URL {

    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static LocalDate convertDate(String textDate, LocalDate defaultValue){
        String[] dateSplited = textDate.split("-");
        System.out.println(dateSplited);
        try{
            return
                    LocalDate.of(Integer.parseInt(dateSplited[0]),
                            Integer.parseInt(dateSplited[1]),
                            Integer.parseInt(dateSplited[2]));
        }catch (Exception e){
            return defaultValue;
        }
    }
}
