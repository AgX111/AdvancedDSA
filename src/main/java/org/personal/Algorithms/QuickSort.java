package org.personal.Algorithms;

public class QuickSort {
    public static void sort(int[] nums){
        partition(nums, 0, nums.length-1);
    }
    public static void partition(int[] nums, int l, int h){
        if(l>=h) return;
        int n = nums.length;
        int pivot_index = (l+h)/2;
        int pivot = nums[pivot_index];
        int i = l, j = l;
        while(j<n){
            if(nums[j]<pivot){
                if(nums[i]==pivot)
                    pivot_index = j;
                swap(nums, i, j);
                ++i;
            }
            ++j;
        }
        swap(nums, i, pivot_index);
        partition(nums, l, i-1);
        partition(nums, i+1, h);
    }
    private static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
