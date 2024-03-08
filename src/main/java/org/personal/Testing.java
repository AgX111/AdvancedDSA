package org.personal;

import org.personal.DataStructures.Pair;
import org.personal.DataStructures.Trie;

import java.util.*;


public class Testing {
    public static void main(String[] args) {


        // Trie dictionary = new Trie(Arrays.asList("danish","zuhaib","dan","dany","hello"));
        Trie dictionary = new Trie(new String[]{"danishzu","zuhaib","dan","dany","hello"});
        System.out.println(dictionary.contains("d"));
        System.out.println(dictionary.contains("dan"));
        System.out.println(dictionary.containsWord("dan"));
        System.out.println(dictionary.contains("dani"));
        System.out.println(dictionary.containsWord("dani"));
        dictionary.insert("dani");
        System.out.println(dictionary.containsWord("dani"));
        System.out.println(dictionary.noOfCharactersMatched("danishzuhaib"));
    }
}
