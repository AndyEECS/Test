package eecs.mm;

import java.util.ArrayList;
import java.util.List;

public class M3
{
    /*
    Receives a non-empty list of strings and a char and returns the string in the list
    that has the most occurrences of that char. If more than one such string is found,
    return the one that occurs last in the list, and if none is found then return the
    empty string.

    For example, if bag = [hello, inclined plane, full ceiling, magic trick] then
     occursMost(bag, 'l') returns "full ceiling"
     occursMost(bag, 'i') returns "magic trick"
     occursMost(bag, 's') returns ""

    */
    public static String occursMost(List<String> bag, char c)
    {
        int most = 0;
        String frequency = "";
        for (String s : bag)
        {
            int count = s.length() - s.replace(String.valueOf(c), "").length();
            if (count >= most)
            {
                most = count;
                frequency = s;
            }
        }
        if (most == 0) frequency = "";
        return frequency;
    }

    public static void main(String[] args)
    {
        List<String> bag = new ArrayList<>();
        bag.add("hello");
        bag.add("inclined plane");
        bag.add("full ceiling");
        bag.add("magic trick");
        System.out.println(M3.occursMost(bag, 's'));
    }
}
