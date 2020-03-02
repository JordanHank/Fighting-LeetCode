import java.util.HashMap;
import java.util.Map;

/**
 * Program Name: Fighting-LeetCode
 * <p>
 * Description: 计算两数之和
 * <p>
 * Created by Zhang.Haixin on 2020-03-02 21:37
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class NumsSum {


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
}
