## 两数之和

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

```text
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

### 简单实现

拿到题的第一想法是使用两层遍历的方式依次取出数字进行计算从而获取到结果。

````java
public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    boolean find  = false;
    for(int i = 0; i < nums.length; i++) {
        int j;
        for (j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                find = true;
                break;
            }
        }
        if (find) {
            result[0] = i;
            result[1] = j;
            break;
        }
    }
    return result;
}
````
复杂度分析： 时间复杂度：O(n^2) 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n) 的时间。因此时间复杂度为 O(n^2)。 空间复杂度：O(1)。

### 优化方案

由于数组中有且只有一组解，这种一对一的特殊答案组和可以利用Map 的特性进行快速查找。

````java
public static int[] twoSumMap(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> sumMap = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
        int current = nums[i];
        if (null != sumMap.get(current)) {
            result[0] = sumMap.get(current);
            result[1] = i;
            break;
        }
        sumMap.put(target - current, i);
    }
    return result;
}
````

复杂度分析： 时间复杂度：O(n)，我们之需要遍历一次数组就可以找到答案，空间复杂度O(n)。

