package eecs.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by qiangxinglin on 2017/3/29.
 */

public class M3 {
    /* Given a non-empty list of strings, this method groups these strings
    by length; selects the lexicographically largest one in each group;
    and returns the selected ones as a lexicographically sorted set.

    (Recall that lexicographic sorting is based on the content of the
    strings, not their lengths; e.g. "Canada" is less than "May" even
    though it is longer in length.)

    For example, if list = [Milk, Bread, Banana, Toast, Juice, Can] then
    the return would be [Banana, Can, Milk, Toast] because in the group
    of length 5 there are three strings ("Bread", "Toast", and "Juice")
    and of these "Toast" is lexicographically the largest.

    */
    public static Set<String> largestPerLength(List<String> list)
    {
        Set<String> set = new TreeSet<>();
        Collections.sort(list);
        for (String s : list)
        {
            String largest = s;
            for (String c : list)
            {
                if (s.length() == c.length())
                {
                    for (int i = 0; i < s.length(); i++)
                    {
                        if (largest.charAt(i) < c.charAt(i)) largest = c;
                    }
                }
            }
            set.add(largest);
        }

        return set;
    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList("Milk", "Bread", "Banana", "Toast", "Juice", "Can");
        System.out.println(largestPerLength(list));
    }
}
