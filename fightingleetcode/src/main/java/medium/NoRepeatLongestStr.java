package medium;

/**
 * Program Name: Fighting-LeetCode
 * <p>
 * Description: 无重复字符的最长子串
 * <p>
 * Created by Zhang.Haixin on 2020-03-04 21:50
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class NoRepeatLongestStr {

    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            String charStr = s.substring(i, i + 1);
            String next = s.substring(i + 1);
            int charNext = next.indexOf(charStr);
            if (charNext > -1) {
                int front = lengthOfLongestSubstring(s.substring(0, charNext + longest + 1));
                int back = lengthOfLongestSubstring(s.substring(i + 1));
                longest = front > back ? front : back;
                break;
            }
            longest++;
        }
        return longest;
    }


    //错误的实现
    public static int lengthOfLongestSubstringError(String s) {
        int longest = 0;
        String front = "";
        for (int i = 0; i < s.length(); i++) {
            String charStr = s.substring(i, i + 1);
            String next = s.substring(i + 1);
            int charNext = next.indexOf(charStr);
            if (i == charNext + i) {
                if (i + 1 >= next.length()) {
                    longest = i + 1;
                } else {
                    longest = lengthOfLongestSubstring(next);
                }
                break;
            }
            if (charNext > -1) {
                String longestStr = "";
                if (charNext + front.length() + 1 > next.length() - charNext) {
                    longestStr = front + charStr + next.substring(0, charNext + 1 >= next.length() ? charNext : charNext + 1);
                } else {
                    longestStr = s.substring(i == 0 ? 1 : i);
                }
                longest = lengthOfLongestSubstring(longestStr);
                break;
            }
            longest++;
            front += charStr;
        }
        return longest;
    }
}
