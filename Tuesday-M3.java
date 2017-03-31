package eecs.mm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class M3
{
    /*
    Given a list containing two or more integers, return a set containing the
    integers in the list that are closest to each other; i.e. the absolute value
    of the difference between them is minimal. The returned set must be sorted.

    For example, if list = [21, 4, 2, 12, 18, 24, 16, 7, 20, 39, -3, 26] then
    the return would be [20, 21]

    */
    public static Set<Integer> differenceMinimal (List<Integer> integers)
    {
        Set<Integer> newSet = new TreeSet<>();
        int minimal = Math.abs(integers.get(0) - integers.get(1));
        for (int i : integers)
        {
            for (int s : integers)
            {
                int difference = Math.abs(i - s);
                if (difference < minimal && difference != 0)
                {
                    minimal = difference;
                    newSet.clear();
                    newSet.add(i);
                    newSet.add(s);
                }
            }
        }
        return newSet;
    }

    public static void main(String[] args)
    {
        List<Integer> integers = new ArrayList<>();
        integers.add(21);
        integers.add(4);
        integers.add(2);
        integers.add(12);
        integers.add(18);
        integers.add(24);
        integers.add(16);
        integers.add(7);
        integers.add(20);
        integers.add(39);
        integers.add(-3);
        integers.add(26);
        System.out.println(differenceMinimal(integers));
    }
}
