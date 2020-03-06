package difficult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Program Name: Fighting-LeetCode
 * <p>
 * Description: 寻找两个有序数组的中位数
 * <p>
 * Created by Zhang.Haixin on 2020-03-05 22:32
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class SortedFind {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return getMedian(nums2);
        }
        if (nums2.length == 0) {
            return getMedian(nums1);
        }

        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        list1.addAll(list2);
        return getMedian(list1.stream().sorted().mapToInt(Integer::valueOf).toArray());
    }

    public static double findMedianSortedArraysError(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return getMedian(nums2);
        }
        if (nums2.length == 0) {
            return getMedian(nums1);
        }
        double nums1Median = getMedian(nums1);
        double nums2Median = getMedian(nums2);
        List<Integer> list = new ArrayList<>();
        buildList(nums1, Math.min(nums1Median, nums2Median), Math.max(nums1Median, nums2Median), list);
        buildList(nums2, Math.min(nums1Median, nums2Median), Math.max(nums1Median, nums2Median), list);
        return getMedian(list.stream().sorted().mapToInt(Integer::valueOf).toArray());
    }

    public static double getMedian(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length % 2 == 0) {
            return (double)(nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        } else {
            return nums[nums.length / 2];
        }
    }

    public static void buildList(int[] arr, double min, double max, List result) {
        if (arr.length == 0) {
            return;
        }
        for (int n : arr) {
            if (n >= Math.floor(min) && n <= Math.ceil(max)) {
                result.add(n);
            }
        }
    }
}
