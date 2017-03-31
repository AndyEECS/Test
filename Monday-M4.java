package eecs.mm;

import java.util.Map;
import java.util.TreeMap;

public class M4
{
    /*
    Receives a non-empty map containing city names as keys and the population of those
    cities in millions as values. Returns a map that shows,for each population in the
    received map,how many cities have that population. The returned map must be sorted
    by population.

    For example, if the received map is: {Chicago=6, Los Angeles=5, New York=12, Toronto=5}
    then the returned map is: {5=2, 6=1, 12=1}

    */
    public static Map<Integer,Integer> barChart(Map<String,Integer> map)
    {
        Map<Integer, Integer> newMap = new TreeMap<>();
        for (int s : map.values())  //map.keySet()
        {
            if (!newMap.containsKey(s))
            {
                newMap.put(s, 1);
            }

            else
            {
                newMap.put(s, newMap.get(s) + 1);
            }

        }
        return newMap;
    }

    public static void main(String[] args)
    {
        Map<String,Integer> map = new TreeMap<>();
        map.put("1", 5);
        map.put("2", 5);
        map.put("3", 6);
        map.put("4", 12);
        System.out.println(M4.barChart(map));
    }

}
