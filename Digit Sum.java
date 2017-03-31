package eecs.mm;

public class M1
{
    /*
    Receives an integer n and returns the smallest integer that is greater than
    n and in which the sum of the digits is divisible by 11.

    For example, nextCRC(100) = 119 because 119 is the first integer greater than
    100 and the sum of its digits 1+1+9 = 11 is divisible by 11.

    Other examples: nextCRC(-100) = -92, nextCRC(20) = 29

    */
    public static int nextCRC(int n)
    {
        while (true)
        {
            if (compute(n) % 11 == 0) return n;
            n++;
        }
    }

    public static int compute(int n) {
        n = Math.abs(n);
        int sum = 0;
        while (n > 0)
        {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(M1.nextCRC(-100));
    }
}
