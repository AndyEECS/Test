package eecs.mm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class M2
{
    /*
        Receives a non-empty string, extracts the timestamp embedded in it, and returns its
        time expressed as a 4-digit time using the 24-hour clock. The return is thus of the
        form "hhmm" where hh ranges from "00" to "23" and mm ranges from "00" to "59".

        A timestamp is a substring made up of an integer between 1 and 12 representing the
        hour followed by ':' followed by a two-digit string between "00" and "59" representing
        the minute followed optionally by some whitespace followed by the string "am" or "pm"
        in upper, lower, or mixed case.

        You can convert a timestamp to a 24-hour clock by simply adding 12 to the hour
        if the time is in the afternoon.

        If the entered string has no timestamp embedded in it then return the empty string
        and f it has more than one then return the one that occurs last.

        Example: get24Time("There was a change from 4:35 to 9:25 Pm tomorrow.") = "2125"

        */
    public static String get24Time(String s)
    {
        String regex = "(([1-9]|1[0-2])[:]([0-5][0-9]))[ ]*([aApP][mM])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        String time = "";
        String hours = "";
        String minutes = "";
        String period = "";
        while (matcher.find())
        {
            hours = matcher.group(2);
            minutes = matcher.group(3);
            period = matcher.group(4).toLowerCase();
        }

        if (period.equals("pm")) time = String.valueOf(Integer.parseInt(hours) + 12) + minutes;
        else time = hours + minutes;
        return time;
    }

    public static void main(String[] args)
    {
        String s1 = "There was a change from 4:35 to 9:25 Pm tomorrow.";
        System.out.println(get24Time(s1));
    }

}
