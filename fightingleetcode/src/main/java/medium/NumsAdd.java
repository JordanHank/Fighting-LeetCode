package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Program Name: Fighting-LeetCode
 * <p>
 * Description: 两数相加
 * <p>
 * Created by Zhang.Haixin on 2020-03-03 21:08
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class NumsAdd {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long num1 = node2Long(l1);
//        long num2 = node2Long(l2);
//        long sum = num1 + num2;
//        return long2Node(sum);

        String num1Str = node2String(l1);
        String num2Str = node2String(l2);
        String sum = numsAdd(num1Str, num2Str);
        return string2Node(sum);
    }

    public static String numsAdd(String num1Str, String num2Str) {
        String min = num1Str.length() > num2Str.length() ? num2Str : num1Str;
        String max = num1Str.length() > num2Str.length() ? num1Str : num2Str;
        Stack<Integer> nums = new Stack<>();
        int forward = 0;
        for (int i = max.length() - 1; i >= 0; i--) {
            int current_min = Integer.valueOf(String.valueOf(min.charAt(i)));
            int current_max = Integer.valueOf(String.valueOf(max.charAt(i)));
            int sum = current_min + current_max;
            if (forward != 0) {
                sum += forward;
            }
            if (sum >= 10) {
                forward = Integer.valueOf(String.valueOf(String.valueOf(sum).charAt(0)));
                nums.push(Integer.valueOf(String.valueOf(String.valueOf(sum).charAt(1))));
            } else {
                forward = 0;
                nums.push(Integer.valueOf(String.valueOf(String.valueOf(sum).charAt(0))));
            }
        }
        String result = "";
        while(!nums.isEmpty()) {
            result += nums.pop();
        }
        return result.trim();
    }

    public static String node2String(ListNode node) {
        String num1Str = "";
        if (null != node.next) {
            num1Str += node2Long(node.next);
        }
        return num1Str += node.val;
    }

    public static int node2Long(ListNode node) {
        String num1Str = "";
        if (null != node.next) {
            num1Str += node2Long(node.next);
        }
        num1Str += node.val;
        return Integer.valueOf(num1Str);
    }

    public static ListNode string2Node(String sum) {
        ListNode result = null;
        for (int i = 0; i < sum.length(); i++) {
            int current = Integer.valueOf(String.valueOf(sum.charAt(i)));
            if (null == result) {
                result = new ListNode(current);
            } else {
                ListNode temp = new ListNode(current);
                temp.next = result;
                result = temp;
            }
        }
        return result;
    }

    public static ListNode long2Node(long sum) {
        ListNode result = null;
        for (int i = 0; i < String.valueOf(sum).length(); i++) {
            int current = Integer.valueOf(String.valueOf(String.valueOf(sum).charAt(i)));
            if (null == result) {
                result = new ListNode(current);
            } else {
                ListNode temp = new ListNode(current);
                temp.next = result;
                result = temp;
            }
        }
        return result;
    }

    public static int nodeLength(ListNode node) {
        int length = 0;
        if (null != node.next) {
            length = nodeLength(node.next);
        }
        length++;
        return length;
    }
}
