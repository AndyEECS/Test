package eecs.mm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class M4
{
    /*
    Receives a non-empty list of words and return a map containing the
    the distribution statistics of the word lengths. For each length,
    the map contains the length as key and the number of words that
    have that length as value.

    The returned map must be sorted by word length.

    For example, if list = [Hello, Test, Book, Vancouver, Glass, Canada, Light]
    then the return would be: {4=2, 5=3, 6=1, 9=1}

    */
    public static Map<Integer,Integer> nameChart(List<String> words) //!!!notice: change the name of variables to original
    {
        Map<Integer, Integer> newMap = new TreeMap<>();
        for (String s : words)
        {
            int length = s.length();
            if (!newMap.containsKey(length))
            {
                newMap.put(length, 1);
            }

            else
            {
                newMap.put(length, newMap.get(length) + 1);
            }
        }
        return newMap;
    }

    public static void main(String[] args)
    {
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("Test");
        words.add("Book");
        words.add("Vancouver");
        words.add("Glass");
        words.add("Canada");
        words.add("Light");
        System.out.println(nameChart(words));
    }
}

