// FILEPATH: /home/agx1/Dsa/AdvancedDSA/src/test/java/org/personal/Algorithms/QuickSelectTest.java

package org.personal.Algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSelectTest {
    @Test
    void testSelectLargest() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        assertEquals(101, QuickSelect.selectLargest(nums, 1));
        assertEquals(18, QuickSelect.selectLargest(nums, 2));
        assertEquals(10, QuickSelect.selectLargest(nums, 3));
    }

    @Test
    void testSelectSmallest() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        assertEquals(2, QuickSelect.selectSmallest(nums, 1));
        assertEquals(3, QuickSelect.selectSmallest(nums, 2));
        assertEquals(5, QuickSelect.selectSmallest(nums, 3));
    }
}