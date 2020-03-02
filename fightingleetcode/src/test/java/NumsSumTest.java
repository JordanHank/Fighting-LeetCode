import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Program Name: Fighting-LeetCode
 * <p>
 * Description: 计算两数之和测试类
 * <p>
 * Created by Zhang.Haixin on 2020-03-02 21:41
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class NumsSumTest {

    @Test
    public void testSum() {
        int[] content = new int[]{2, 7, 11, 15};
//        int[] result = NumsSum.twoSumMap(content, 9);
        int[] result = NumsSum.twoSumMap(content, 9);
        assertArrayEquals(new int[]{0, 1}, result);

        int[] content2 = new int[]{3, 3};
//        int[] result2 = NumsSum.twoSum(content2, 6);
        int[] result2 = NumsSum.twoSumMap(content2, 6);
        assertArrayEquals(new int[]{0, 1}, result2);

        int[] content3 = new int[]{2, 5, 5, 11};
//        int[] result3= NumsSum.twoSum(content3, 10);
        int[] result3= NumsSum.twoSumMap(content3, 10);
        assertArrayEquals(new int[]{1, 2}, result3);
    }
}
