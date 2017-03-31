package eecs.test;



public class M2
{
    /*
    Given a non-empty string,determine the longest sequence of repeating characters
    in it (i.e. consecutive characters that are the same) and return the repeating
    character and its repetition count delimited by an equal sign. If more than one
    such sequence is found, the return should be about the one that occurs first in
    the string.

    Example: longest("ZZZZAISSDRRIIIIIIIHHHQQQDDDDDDDZZZZZDD") returns "I=7" because
    there are two longest repeating sequences in this string (D and I, each repeating
    7 times) and the I sequence occurs before the D sequence.

    */
    public static String longest(String s)
    {
        int count = 1;
        int longestCount = 0;
        int repeatBegin = 0;
        for(int i=0; i < s.length() - 1; i++)
        {
            while(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1))
            {
                i++;
                count++;
            }
            if(count > longestCount){
                longestCount = count;
                repeatBegin = i;
            }
            count = 1;
        }
        return s.charAt(repeatBegin)+ "=" + longestCount;
    }

    public static void main(String[] args) {
        String s = "ZZZZAISSDRRIIIIIIIHHHQQQDDDDDDDZZZZZDD";
        System.out.println(longest(s));
    }
}
