package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Program Name: Fighting-LeetCode
 * <p>
 * Description: 无重复字符的最长子串测试
 * <p>
 * Created by Zhang.Haixin on 2020-03-04 21:51
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class NoRepeatLongestStrTest {

    @Test
    public void test() {
        String str1 = "bbbbb";
        assertEquals(1, NoRepeatLongestStr.lengthOfLongestSubstring(str1));

        String str2 = "cdd";
        assertEquals(2, NoRepeatLongestStr.lengthOfLongestSubstring(str2));

//        String str3 = "pwwkew";
//        String str3 = "abcb";
//        String str3 = "dvdf";
        String str3 = "abcabcbb";
        assertEquals(3, NoRepeatLongestStr.lengthOfLongestSubstring(str3));

        String str4 = "anviaj";
        assertEquals(5, NoRepeatLongestStr.lengthOfLongestSubstring(str4));

//        String str5 = "ohvhjdml";
        String str5 = "jxdlnaaij";
        assertEquals(6, NoRepeatLongestStr.lengthOfLongestSubstring(str5));
    }
}
