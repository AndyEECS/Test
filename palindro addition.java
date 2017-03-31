package eecs.test;


public class M1
{
    /*
    Given a positive integer n, return the number of "palindro additions" needed
    to make it a palindrome (i.e. reads the same left-to-right and right-to-left).
    A "palindro addition" is the addition of the number to its inverse.

    For example, if n = 159 then the first palindro addition yields 159+951=1110,
    and the second palindro addition yields 1110+111=1221, which is a palindrome.
    Hence, the palindro count of 159 is 2.

    If n is already a palindrome then return zero, and if the number does not
    become a palindrome after 10 palindro additions then return -1.

    */
    public static int palindroCount(int n)
    {
        int result = 0;
        if (!isPalindrome(n))
        {
            result = 1;
            while (!isPalindrome(n +invert(n)))
            {
                result++;
                n += invert(n);
                if (result > 10) result = -1;
            }
        }
        return result;
    }

    private static int invert(int n)
    {
        String invert = "";
        String number = String.valueOf(n);
        for (int i = 0; i < number.length(); i++)
        {
            invert += number.charAt(number.length() - 1 - i);
        }
        return Integer.parseInt(invert);
    }

    private static boolean isPalindrome(int n)
    {
        boolean result = true;
        String number = String.valueOf(n);
        for (int i = 0; i < number.length(); i++)
        {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i)) result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(11));
        System.out.println(isPalindrome(1431));
        System.out.println(isPalindrome(131));
        System.out.println(invert(7654));
        System.out.println(palindroCount(7325));
    }
}

