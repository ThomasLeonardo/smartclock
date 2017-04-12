package br.ufpe.nti.util;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class CalculateAngle
{
    public static double calculate(Calendar cal)
    {
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        
        double angle = calculateAbsoluteDifferenceBetweenAngles(hour, minute);
        return angle;
        
    }
    
    public static double calculate(LocalTime time)
    {
        int hour = time.getHour();
        hour = hour >= 12 ? hour - 12 : hour;
        int minute = time.getMinute();
        
        double angle = calculateAbsoluteDifferenceBetweenAngles(hour, minute);
        return angle;
    }
    
    private static double calculateAbsoluteDifferenceBetweenAngles(int hour, int minute)
    {
        double angleHour = getHourHandAngle(hour, minute);
        double angleMinute = getMinuteHandAngle(minute);
        double angle = Math.abs(angleHour - angleMinute);
        return angle;
    }
    
    private static double getHourHandAngle(int hour, int minute)
    {
        double hourHandAngle = 0.5 * (60 * hour + minute);
        return hourHandAngle;
    }
    
    private static int getMinuteHandAngle(int minute)
    {
        int minuteHandAngle = 6 * minute;
        return minuteHandAngle;
    }
}
