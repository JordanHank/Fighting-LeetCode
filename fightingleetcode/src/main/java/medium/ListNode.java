package medium;

/**
 * Program Name: Fighting-LeetCode
 * <p>
 * Description: Definition for singly-linked list.
 * <p>
 * Created by Zhang.Haixin on 2020-03-03 21:10
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode(int x) { val = x; }

    @Override
    public boolean equals(Object obj) {
        if (null == next) {
            return val == ((ListNode)obj).val;
        }
        return next.equals(((ListNode)obj).next);
    }
}
