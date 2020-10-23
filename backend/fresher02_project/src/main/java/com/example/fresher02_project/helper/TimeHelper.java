package com.example.fresher02_project.helper;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeHelper {

    public Date getDateTimeNow(){

        java.util.Date date=new java.util.Date();
        return date;
    }

    public String formatIntoSqlDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        String sqlDate = simpleDateFormat.format(date);
        return sqlDate;

    }
}
