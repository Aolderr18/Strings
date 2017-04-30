import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PseudoIsomorphicStrings {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        String s;
        do
            s = input.next();
        while (s.length() < 1 || s.length() > 100000);
        String sub;
        for (int l = 1; l <= s.length(); ++l) {
            sub = s.substring(0, l);
            LinkedList<String> possibleSubstrings = possibleSubstrings(sub);
            boolean containsPseudoIsomorphic = true;
            while (containsPseudoIsomorphic) {
                containsPseudoIsomorphic = false;
                int removalIndex = 0;
                for (int n = 0; n < possibleSubstrings.size(); ++n)
                    for (int g = 0; g < possibleSubstrings.size(); ++g) {
                        if (n == g)
                            continue;
                        if (pseudoIsomorphic(possibleSubstrings.get(n), possibleSubstrings.get(g))) {
                            containsPseudoIsomorphic = true;
                            removalIndex = g;
                        }
                    }
                if (containsPseudoIsomorphic)
                    possibleSubstrings.remove(removalIndex);
            }
            System.out.println(possibleSubstrings.size());
            possibleSubstrings.clear();
        }
        input.close();
    }
    
    private static boolean pseudoIsomorphic(String s, String compare) {
        if (s.length() != compare.length())
            // Two Strings must be equal to be considered isomorphic.
            return false;
        for (int a = 0; a < s.length(); ++a)
            for (int b = 0; b < s.length(); ++b) 
                if (a != b) 
                    if ((s.charAt(a) == s.charAt(b) && compare.charAt(a) != compare.charAt(b))
                       || (s.charAt(a) != s.charAt(b) && compare.charAt(a) == compare.charAt(b)))
                        return false;
        return true;
    }
    
    private static LinkedList<String> possibleSubstrings(String s) {
        LinkedList<String> possibleSubstrings = new LinkedList<String>();
        int subLength = s.length(); // The length of the current substring
        int numberOfAdditions = 1; // The number of substrings given the substring length
        int x;
        while (subLength >= 1) {
            for (x = 0; x < numberOfAdditions; ++x)
                possibleSubstrings.add(new String(s.substring(x, x + subLength)));
            numberOfAdditions++; 
            subLength--;
            /*
            * The number of substrings should increase by one each time the length of each substring
            * decreases by one.
            */
        }
        return possibleSubstrings;
    }
}
