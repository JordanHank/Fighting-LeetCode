## 寻找两个有序数组的中位数

给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例1：

```text
nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
```

示例 2:

````text
nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
````

### 想法

首先想法是既然是两个有序数据，那是不是可以先分别取出这两个有序数组的中位数，然后遍历两个数组找出在两个中位数之间的所有数据得到一个集合，最后从获取到的集合里面取中位数就行了呢。

```java
public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
```

果然没有这么简单，提交了几次都没有通过检测，估计是思路有问题。

### 转换思路

既然从两个数组中分别找出各自的中位数，在根据找出的中位数组成新的数组，接着在新的数组中找出中位数的思路行不通，可以换个思路，要找两个有序数组的中位数，无非就是要将两个数组合并成一个新的有序数组，再根据奇偶情况获取中位数。

因为两个数组不会同时为空，所以当有数组为空的时候之需要把不为空的数组根据奇偶情况获取中位数即可。

```java
 if (nums1.length == 0) {
        return getMedian(nums2);
}
if (nums2.length == 0) {
    return getMedian(nums1);
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
```

问题的难点是怎么将不为空的两个数组合并成一个新的有序数组，在不考虑时间复杂度为 O(log(m + n))的情况下，直接转换成集合进行合并就行了。

```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
```

这样确实可以达到解题的目的，但是并不符合题目要求的时间复杂度为 O(log(m + n))，只是证明这个思路是可行的。
