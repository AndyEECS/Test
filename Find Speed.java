package eecs.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class M2
{
    /*
    Receives a non-empty string s and extracts the speed embedded in it
    and return it rounded to the nearest integer.
     .
    The speed is a real number followed by one or more blanks followed
    by "m/s" in lower, upper, or mixed case. If no such speed occurs in
    the string then return -1, and if more than one is found then extract
    the one that occurs last in the string.

    Note that the real number may or may not include a decimal point so
    it may appear, for example, as 3.4 or 12 or 7. or .5 or 0.5 ... etc.

    Examples:
    getSpeed("Measure 9.m/ and .3 m/s find 8 m/s or 3.6 m/s of .5m/s") = 4
    getSpeed("Measure 9.m/ and .4 m/s find 8 cM/s or 3m m/s of .1m/s") = 0
    getSpeed("Measure 9.m/ and .3 m/s find 8 m/s or 3.6 cm/S of .5M/S") = 8

    */

    public static int getSpeed(String s)
    {
        String regex = "([ ]\\d*[.]?\\d+)[ ]+(?:[mM][/][sS])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        String speed = "";
        while (matcher.find()) speed = matcher.group(1);
        double value = Double.parseDouble(speed);
        return (int)Math.round(value);
    }

    public static void main(String[] args)
    {
        String[] tests = {"Measure 9.m/ and .3 m/s find 8 m/s or 3.6 m/s of .5m/s",
                            "Measure 9.m/ and .4 m/s find 8 cM/s or 3m m/s of .1m/s",
                            "Measure 9.m/ and .3 m/s find 8 m/s or 3.6 cm/S of .5M/S"};

        for (String s: tests) {
            System.out.println("Test case:\n" + s);
            System.out.println("Speed:\n" + getSpeed(s));
        }
    }

}
