package com.soayjonyit.matrix;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashSet;
import java.util.Set;

public class Permutation {
    public static void main(String[] arges) {
        String s = "AABCYUERJEY";
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(solution(s));
        stopWatch.stop();
        System.out.println("Time elapse: " + stopWatch.getTime());
    }

    public static int solution(String s ) {
        int count = 0;
        Set<String> perms = permutationFinder( s);
        //perms.stream().forEach(System.out::println);
        String vowels = "AEIOU";
        for(String word: perms) {
            if(vowels.indexOf(word.charAt(0)) > -1) {
                continue;
            }
            boolean isConsonant = false;
            for(int i = 1; i < word.length(); i+=2) {
                int j = i - 1;
                if( (j > 0 && vowels.indexOf(word.charAt(j)) > -1) || vowels.indexOf(word.charAt(i)) == -1) {
                    isConsonant = true;
                    break;
                }
            }
            if(isConsonant) {
                continue;
            }
            System.out.println(word);
            count++;
        }
        return count;
    }


    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<>();

        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++) {
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    private static Set<String> permutation(String prefix, String str) {
        Set<String> permutations = new HashSet<>();
        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations.addAll(permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)));
            }
        }
        return permutations;
    }
}
