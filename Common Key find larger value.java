package eecs.test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by qiangxinglin on 2017/3/29.
 */

public class M4 {
    /*
    Given two maps, return a map whose keys are the common keys between them and
    whose values are the larger of the two values of each common key. The returned
    map must be sorted on its keys.

    Example:
      map1 = {May=2, Screen=3, Paper=12, Key=23}
      map2 = {May=7, Screen=2, Book=12, File=11}
    In this case the return would be {May=7, Screen=3} because May and Screen are
    the common keys in the two given maps. The value for key "May" is 2 in one map
    and 7 in the other so we pick the larger 7. Similarly, we pick 3 for Screen.

    */
    public static Map<String, Integer> fuse(Map<String,Integer> map1, Map<String,Integer> map2)
    {
        Map<String, Integer> map = new TreeMap<>();
        for (String s1 : map1.keySet())
        {
            for (String s2 : map2.keySet())
            {
                if (s1.equals(s2))
                {
                    map.put(s1, Math.max(map1.get(s1), map2.get(s2)));
                }
            }
        }

        return map;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new TreeMap<>();
        map1.put("May", 2);
        map1.put("Screen", 3);
        map1.put("Paper", 12);
        map1.put("Key", 23);
        Map<String, Integer> map2 = new TreeMap<>();
        map2.put("May",7);
        map2.put("Screen", 2);
        map2.put("Book", 12);
        map2.put("File", 11);
        System.out.println(fuse(map1, map2));

    }
}
