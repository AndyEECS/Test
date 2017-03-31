package eecs.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



public class M4
{
    /*
    Given a list of elements each of which is a list of strings containing
    expenses made on food items, consolidate the expenses and return a map
    whose keys are the expense names and whose values are the total spent
    per expense. The expenses are expressed in the strings as an expense name
    (a word) followed by a colon followed by the expense amount (an integer).

    For example, if the incoming list is:

      [[Milk:12, Bread:3, Banana:4, Soup:2], [Honey:6, Bread:1, Milk:3]]

    then the return would be:

      {Banana=4, Bread=4, Honey=6, Milk=15, Soup=2}

    As you can see, the amounts for Bread and Milk are obtained by adding
    up their respective amounts in the two incoming lists.

    */
    public static Map<String,Integer> expense(List<List<String>> list)
    {
        Map<String, Integer> map = new TreeMap<>();
        for (List<String> inside : list)
        {
            for (String s : inside)
            {
                String[] data = s.split(":");
                if (!map.containsKey(data[0]))
                {
                    map.put(data[0], Integer.parseInt(data[1]));
                }
                else
                {
                    map.put(data[0], map.get(data[0]) + Integer.parseInt(data[1]));
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Milk:12", "Bread:3", "Banana:4", "Soup:2");
        List<String> list2 = Arrays.asList("Honey:6", "Bread:1", "Milk:3");
        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        System.out.println(expense(list));
    }
}
