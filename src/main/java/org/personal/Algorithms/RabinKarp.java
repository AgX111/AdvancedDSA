package org.personal.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
    
    private static final int PRIME = 256;
    private static final int MOD = (int) (1e9+7);
//    private static final int MOD = (int) 101;

    public static long modExp(int base, int exponent, int mod) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * (long) base) % mod;
            }
            exponent >>= 1;
            base = (int) ((base * (long) base) % mod);
        }
        return result;
    }

    public static long calculateHash(String str){
        int patternLength = str.length();
        long hash = 0;
        for(int i = 0;i<patternLength;i++){
            hash = (hash*PRIME + str.charAt(i)) % MOD;
        }
        return hash;
    }

    public static long updateHash(char oldChar, char newChar, long oldHash, long CONSTANT){
        oldHash  = ((oldHash)%MOD - (oldChar*CONSTANT)%MOD + MOD) % MOD;
        oldHash = oldHash * PRIME;
        oldHash = (oldHash + newChar) % MOD;
//        oldHash = (PRIME*(oldHash-oldChar*CONSTANT)+newChar) % MOD;
        return oldHash;
    }
    
    public static List<Integer> findOccurrences(String text, String pattern){
        int textLength = text.length();
        int patternLength = pattern.length();
        long CONSTANT = RabinKarp.modExp(PRIME, patternLength-1, MOD); // s(i)*d^(m-1), where s(i) is oldChar, d is PRIME/BASE
        List<Integer> indices = new ArrayList<>();
        String startString = text.substring(0,patternLength);
        long currHash = RabinKarp.calculateHash(startString);
        long patternHash = RabinKarp.calculateHash(pattern);

        for(int i = 0;i<=textLength-patternLength;i++){
            if(patternHash == currHash && pattern.equals(text.substring(i,i+patternLength))){
                indices.add(i);
            }
            if(i+patternLength<textLength)
                currHash = RabinKarp.updateHash(text.charAt(i), text.charAt(i+patternLength), currHash, CONSTANT);
        }
        return indices;
    }
    public static void main (String[] args){
        System.out.println(Math.pow(26,8)%MOD);
        System.out.println(RabinKarp.modExp(26,8, MOD));
    }
}
