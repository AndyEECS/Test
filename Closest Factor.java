package eecs.test;

/**
 * Created by qiangxinglin on 2017/3/29.
 */

public class M1 {
    /*
    Given a positive integer n, find a pair of positive integers whose product
    is n and whose difference in absolute value is minimal (i.e. less than the
            difference of any other such pair). The method returns that minimal difference.
    Note that the two integers need not be different.

    For example, closestFactors(200) = 10 because of the many pairs whose product
    is 200, such as (4,50) and (25,8), the pair (20,10) has the least difference
    |10-20|=10. As a second example, closestFactors(100) = 0 because (10,10) is the
    sought pair.
     */

    public static int closestFactors(int n)
    {
        int closest = n;
        for (int i = 1; i < n; i++)
        {
            int difference = n;
            if (n % i == 0) difference = Math.abs(i - n / i);
            if (closest > difference) closest = difference;
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(closestFactors(100));
        System.out.println(closestFactors(200));
    }
}
