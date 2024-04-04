package org.personal.Algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {
    @Test
    void testSort() {
        int[] nums = {9,0,1,0};
        QuickSort.sort(nums);
        assertArrayEquals(new int[]{0,0,1,9}, nums);

        nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        QuickSort.sort(nums);
        assertArrayEquals(new int[]{2, 3, 5, 7, 9, 10, 18, 101}, nums);
    }
}