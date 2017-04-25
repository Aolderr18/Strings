/**
* Submissions: 8276
* Max Score: 100
* Difficulty: Expert
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MorganAndAString {
    private static final String capitalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int t;
        do
            t = input.nextInt();
        while (t < 1 || t > 5);
        while (t-- > 0) {
            String jack = input.next();
            String daniel = input.next();
            StringBuilder lexicograph = new StringBuilder();
            int jIndex = 0;
            int dIndex = 0;
            char j = ' ', d = ' ';
            while (jIndex < jack.length() || dIndex < daniel.length()) {
                if (jIndex < jack.length())
                    j = jack.charAt(jIndex);
                if (dIndex < daniel.length())
                    d = daniel.charAt(dIndex);
                if (jIndex < jack.length() && dIndex < daniel.length()) {
                    if (capitalAlphabet.indexOf(j) < capitalAlphabet.indexOf(d)) {
                        ++jIndex;
                        lexicograph.append(j);
                    } else {
                        ++dIndex;
                        lexicograph.append(d);
                    }
                } else if (jIndex < jack.length()) {
                    lexicograph.append(j);
                    ++jIndex;
                } else {
                    lexicograph.append(d);
                    ++dIndex;
                }
            }
            System.out.println(lexicograph.toString());
        }
        input.close();
    }
}
