package com.flsoluction.prestamos.FlSoftSolution;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jfeliz on 2/16/2018.
 */

public class DateUtility {

    /**
     * Addquiere la cantidad de meses a la fecha
     * @param fecha Fecha
     * @param cantMonth Cantidad de meses
     * @return Fecha con cantidad de meses adquirida
     */
    public static Date addMonth(Date fecha,int cantMonth){
        getCalendar().setTime(fecha);

        _calendar.add(Calendar.MONTH,cantMonth);

        return _calendar.getTime();
    }

    /**
     * Addquiere la cantidad de dias a la fecha
     * @param fecha Fecha
     * @param cantDays Cantidad de dias
     * @return Fecha con cantidad de meses adquirida
     */
    public static Date addDays(Date fecha,int cantDays){
        getCalendar().setTime(fecha);

        _calendar.add(Calendar.DAY_OF_YEAR,cantDays);

        return _calendar.getTime();
    }

    public  static  int SubtractToDay(Date ini,Date fin){
        int dias;

        getCalendar().setTimeInMillis(fin.getTime() -ini.getTime());

        return _calendar.get(Calendar.DAY_OF_YEAR);
    }

    static Calendar _calendar;

    public static Calendar getCalendar() {
        if (_calendar == null){
            _calendar = Calendar.getInstance();
        }

        return _calendar;
    }

    public static String format(Date fecha,String format){
        String fechaFormat;
        SimpleDateFormat simpleFormat = new SimpleDateFormat(format,new Locale("es","ES"));

        return simpleFormat.format(fecha);
    }

    public static Date getCurrentDate(){
        return getCalendar().getTime();
    }
}
