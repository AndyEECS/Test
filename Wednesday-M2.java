package eecs.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qiangxinglin on 2017/3/29.
 */

public class M2 {
    /*
    Receives a non-empty string and looks in it for the pattern:

       b=X&e=Y&d=Z

    where X is an arbitrary integer, Y is an arbitrary real number and d is an integer
    between 0 and 3, inclusive. It returns X raised to Y rounded to Z decimals. If the
    pattern is not found in the string then the method returns null. Note that Y can be
    entered with or without a decimal point, e.g. 3 or 3.5 or 0.4 or .5.

    Examples:
    myPow(b=2&e=5&d=1) = 32.0
    myPow(b=2&e=-.5&d=3) = 0.707
    myPow(b=-2&e=.5&d=0) = NaN
*/
    public static String myPow(String s)
    {
        try
        {
            String regex = "^[b][=]([-]*\\d+)[&][e][=]([-]*\\d*[.]*\\d+)[&][d][=]([0-3])$";

            double result;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            String result2 = "";
            while (matcher.find())
            {
                int b = Integer.parseInt(matcher.group(1));
                double e = Double.parseDouble(matcher.group(2));
                int d = Integer.parseInt(matcher.group(3));
                result = Math.pow(b, e);
                result2 = String.format("%." + d + "f", result);
            }

            return result2;
        }
        catch (Exception e)
        {
            return "NaN";
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow("b=2&e=5&d=1"));
        System.out.println(myPow("b=2&e=-.5&d=3"));
        System.out.println(myPow("b=-2&e=.5&d=0"));
    }

}
