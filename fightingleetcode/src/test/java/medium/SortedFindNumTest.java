package medium;

import difficult.SortedFind;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Program Name: Fighting-LeetCode
 * <p>
 * Description: 寻找两个有序数组的中位数测试
 * <p>
 * Created by Zhang.Haixin on 2020-03-05 22:33
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class SortedFindNumTest {

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 3, 5, 8, 9, 10};
        int[] nums2 = new int[]{2, 4, 5, 6, 7, 8};
//        int[] nums1 = new int[]{};
//        int[] nums2 = {1, 2, 3,4};
        assertEquals(5.5d, SortedFind.findMedianSortedArrays(nums1, nums2), 0.01);
    }
}
