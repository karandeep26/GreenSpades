package com.proj.greenspades;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by karan on 23/11/17.
 */

public class Utils {
    private static Calendar cal = Calendar.getInstance();
    @SuppressLint("SimpleDateFormat")
    public static String getFormattedDate(Date date) {

        cal.setTime(date);
        int day = cal.get(Calendar.DATE);

        switch (day % 10) {
            case 1:
                return new SimpleDateFormat("MMMM d'st'  yy").format(date);
            case 2:
                return new SimpleDateFormat("MMMM d'nd'  yy").format(date);
            case 3:
                return new SimpleDateFormat("MMMM d'rd'  yy").format(date);
            default:
                return new SimpleDateFormat("MMMM d'th'  yy").format(date);
        }
    }

}