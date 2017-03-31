package eecs.mm;

public class M1
{

    /*
    Given a double d, its NCount is defined using the sequence:

      x(i+1) = x(i) + A / B, where A = d - x(i)*x(i)*x(i) and B = 3*x(i)*x(i)

    Starting with x(1) = 100, we keep iterating this sequence until the absolute
    value of the difference between two successive terms becomes less than 0.01.
    The number of terms needed to reach this limit is the N-Count of d.

    For example, if d = 12, we compute:
      x(2) = 100 + (12 - 100^3) / (3*100^2) = 66.67

    We then compute:
      x(3) = 66.67 + (12 - 66.67^3) / (3*66.67^2) = 44.45

    Iterating the process yields these terms:
    29.63, 19.76, 13.18, 8.81, 5.93, 4.06, 2.95, 2.43, 2.297, 2.289

    We see that x(12) and x(13) differ by less than 0.01 so NCount(12) = 13.

    */

    public static double x(int n, int d)
    {
        double result = 100;
        for (int i = 1; i < n; i++)
        {
            double pre = x(n - 1, d);
            result = pre + (d - Math.pow(pre, 3)) / (3 * Math.pow(pre, 2));
        }
        return result;
    }

    public static int NCount(int d)
    {
        int n = 1;
        while(true)
        {
            if (x(n, d) - x(n + 1, d) < 0.01) return n + 1;
            n++;

        }
    }

    public static void main(String[] args)
    {
        System.out.println(x(3,12));
        System.out.println(NCount(12));
    }
}
