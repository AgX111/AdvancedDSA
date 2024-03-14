package org.personal;

import org.personal.DataStructures.Pair;
import org.personal.DataStructures.Trie;
import org.personal.Algorithms.KMPAlgorithm;

import java.util.*;


public class Testing {
    public static void main(String[] args) {


        // Trie dictionary = new Trie(Arrays.asList("danish","zuhaib","dan","dany","hello"));
        // Trie dictionary = new Trie(new String[]{"danishzu","zuhaib","dan","dany","hello"});
        // System.out.println(dictionary.contains("d"));
        // System.out.println(dictionary.contains("dan"));
        // System.out.println(dictionary.containsWord("dan"));
        // System.out.println(dictionary.contains("dani"));
        // System.out.println(dictionary.containsWord("dani"));
        // dictionary.insert("dani");
        // System.out.println(dictionary.containsWord("dani"));
        // System.out.println(dictionary.noOfCharactersMatched("danishzuhaib"));

        // Set seed to generate same sequence of random numbers
        long seed = 12345;
        Random random = new Random(seed);

        // Generating a large text string
        StringBuilder textBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            textBuilder.append((char) (random.nextInt(4) + 'a')); // Generating random lowercase letters
        }
        String text = textBuilder.toString();

        // Generating a large pattern
        StringBuilder patternBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            patternBuilder.append((char) (random.nextInt(3) + 'a')); // Generating random lowercase letters
        }
        String pattern = patternBuilder.toString();

        // Running KMP algorithm
        long startTime = System.currentTimeMillis();
        List<Integer> matches = KMPAlgorithm.kmp1(pattern, text);
        long endTime = System.currentTimeMillis();

        // System.out.println("Pattern found at indexes: " + matches);
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }
}
