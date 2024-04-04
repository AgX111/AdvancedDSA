package org.personal.Algorithms;

public class QuickSelect {
    public static int selectLargest(int[] nums, int k){
        // If Kth Largest Element is required, then K = nums.length - K
        return partition(nums, 0, nums.length-1, nums.length-k);
    }
    public static int selectSmallest(int[] nums, int k){
        // If Kth Smallest Element is required, then K = K-1
        return partition(nums, 0, nums.length-1, k-1);
    }
    public static int partition(int[] nums, int l, int h, int k){
        // l will never be greater than h
        if(l==h && l==k) return nums[k];
        int pivot_index = (l+h)/2;
        int pivot = nums[pivot_index];
        int i = l, j = l;
        while(j<=h){
            if(nums[j]<pivot){
                if(nums[i]==pivot)
                    pivot_index = j;
                swap(nums, i, j);
                ++i;
            }
            ++j;
        }
        swap(nums, i, pivot_index);
        if(i<k) 
            return partition(nums, i+1, h, k);
        else if(i>k)
            return partition(nums, l, i-1, k);
        else
            return nums[i];
    }
    private static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public static void main(String[] args){
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(selectLargest(nums, 8));
        System.out.println(selectSmallest(nums, 8));
    }
}
