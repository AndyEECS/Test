package eecs.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class M3
{
    /*
    Given a non-empty list of strings each of which represents a date, return
    the two dates in it that are closest to each other.

    The date in each string is expressed like "30/3/17@11:30 pm"; i.e. one or
    two digits for the day followed by a slash followed by one or two digits
    for the month followed by a slash followed by 2 or 4 digits for the year.
    The time has one or two digits for the hour followed by a colon followed
    by exactly two digits for the minute followed by one space followed by
    am or pm in upper, lower, or mixed case. The date and time are delimited
    by the @ character.

    The return is a chronologically sorted list of two date objects. If any of
    the incoming strings is invalid, return null. And if the list has more than
    one pair of dates that are equally close, return the pair that occurs first.

    Example: if the given list is:
    [30/3/17@11:30 pm, 31/12/2016@11:10 PM, 1/4/2017@6:00 am, 8/8/2016@12:00 aM, 1/1/2017@5:45 AM, 31/3/17@4:30 aM]
    then the return would be the list:
    [Thu Mar 30 23:30:00 EDT 2017, Fri Mar 31 04:30:00 EDT 2017]

    */

    public static List<Date> closest(List<String> list)
    {
        List<Date> dateList = new ArrayList<>();
        List<Date> result = new ArrayList<>();
        String regex = "\\d{1,2}[/]\\d{1,2}[/](\\d{2}|\\d{4})[@]\\d{1,2}[:]\\d{2}[ ][aApP][mM]";

        Pattern pattern = Pattern.compile(regex);
        SimpleDateFormat parseFormat = new SimpleDateFormat("dd/MM/yy@hh:mm aa", Locale.CANADA);
        for (String s : list)
        {
            Matcher matcher = pattern.matcher(s);
            if (!s.matches(regex)) return null;
            while (matcher.find())
            {
                try
                {
                    dateList.add(parseFormat.parse(matcher.group().toLowerCase()));
                }
                catch (Exception e)
                {
                }
            }
            double minimal = 10000;
            for (Date date1 : dateList)
            {
                for (Date date2 : dateList)
                {
                    if (date1 != date2 && getDifferentDays(date1, date2) < minimal)
                    {
                        minimal = getDifferentDays(date1, date2);
                        result.clear();
                        result.add(date1);
                        result.add(date2);
                    }
                }
            }
        }
        return result;
    }

    public static double getDifferentDays(Date date1, Date date2)
    {
        Calendar first = Calendar.getInstance();
        first.setTime(date1);
        Calendar second = Calendar.getInstance();
        second.setTime(date2);
        long differentMilSec = Math.abs(first.getTimeInMillis() - second.getTimeInMillis());
        return differentMilSec / ((1000 * 24 * 60 * 60));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("30/3/17@11:30 pm", "31/12/2016@11:10 PM", "1/4/2017@6:00 am", "8/8/2016@12:00 aM", "1/1/2017@5:45 AM", "31/3/17@4:30 aM");
        System.out.println(closest(list));
    }
}
