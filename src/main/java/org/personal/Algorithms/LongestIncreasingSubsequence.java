package org.personal.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int upperBound(List<Integer> buff, int target){
        int l = 0, h = buff.size()-1;
        while(l<h){
            int mid = (int) Math.ceil(l + (double)(h-l)/2);
            if(buff.get(mid)<target)
                l = mid;
            else h = mid - 1;
        }
        return (buff.get(l) >= target)?0:l+1;
    }
    public static int length(int[] nums){
        List<Integer> buff = new ArrayList<>();
        for(int num: nums){
            if(buff.isEmpty()) buff.add(num);
            else{
                int index = upperBound(buff, num);
                if(index == buff.size()) 
                    buff.add(num);
                else 
                    buff.set(index, num);
            }
        }
        return buff.size();
    }
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(length(nums));
    }
}
