package org.personal.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {
    public static int[] prefixFunction(String s){
        int[] pi = new int[s.length()];
        pi[0] = 0;
        for(int i=1;i<s.length();++i){
            int j = pi[i-1]; // Length of previous (i-1) LongestPrefixSuffix.
            while(true){
                if(s.charAt(j) == s.charAt(i)){
                    pi[i] = j + 1;
                    break;
                } 
                else if(j == 0){
                    pi[i] = 0; // When index 0 also does not match with index i, LPS becomes 0.
                    break;
                }
                j = pi[j-1];
            }
        }
        return pi;
    }
    public static List<Integer> kmp1(String s, String t){
        int n = s.length();
        List<Integer> indices = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        sb.append("#");
        sb.append(t);
        int[] pi = prefixFunction(sb.toString());

        for(int i = n+1;i<pi.length;++i){
            if(pi[i] == n){
                indices.add(i-2*n);
            }
        }
        return indices;
    }
    public static List<Integer> kmp2(String s, String t){
        int n = s.length();
        List<Integer> indices = new ArrayList<>();
        int[] pi = prefixFunction(s);
        int i = 0, j = 0;

        while(j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                ++i;
                ++j;
                if(i == n){
                    indices.add(j-n);
                    --i;
                }
            }
            else{
                if(i>0){
                    i = pi[i-1];
                }
                else{
                    ++j; // Here i = 0
                }
            }
        }
        return indices;
    }
}
