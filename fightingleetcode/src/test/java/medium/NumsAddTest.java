package medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Program Name: Fighting-LeetCode
 * <p>
 * Description: 两数相加测试类
 * <p>
 * Created by Zhang.Haixin on 2020-03-03 21:12
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class NumsAddTest {

    @Test
    public void testLong2Node() {
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4= new ListNode(4);

        node4.next = node3;
        node2.next = node4;
        assertEquals(node2, NumsAdd.long2Node(342));
    }

    @Test
    public void testNode2Long() {
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4= new ListNode(4);

        node4.next = node3;
        node2.next = node4;
        assertEquals(342, NumsAdd.node2Long(node2));
    }

    @Test
    public void testString2Node() {
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4= new ListNode(4);

        node4.next = node3;
        node2.next = node4;
        assertEquals(node2, NumsAdd.string2Node("342"));
    }

    @Test
    public void testNode2String() {
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4= new ListNode(4);

//        node4.next = node3;
//        node2.next = node4;
//        assertEquals("342", NumsAdd.node2String(node2));

        String result = "6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1";
        ListNode node3 = NumsAdd.string2Node(result.replaceAll(",", "").trim());
        System.out.println(NumsAdd.node2String(node3));;
    }

    @Test
    public void testSum() {
        ListNode node1 = NumsAdd.string2Node("342");
        ListNode node2 = NumsAdd.string2Node("465");
        ListNode node3 = NumsAdd.string2Node("807");
        assertEquals(node3, NumsAdd.addTwoNumbersOffical(node1, node2));

//        ListNode node1 = new ListNode(9);
//        String num = "9999999991";
//        ListNode node2 = NumsAdd.string2Node(num);
//        ListNode node3 = NumsAdd.string2Node("10000000000");

        String num = "1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1";
        ListNode node_1 = NumsAdd.string2Node(num.replaceAll(",", "").trim());
        ListNode node_2 = NumsAdd.string2Node("465");
        String result = "1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,6,6";
        ListNode node_3 = NumsAdd.string2Node(result.replaceAll(",", "").trim());
        assertEquals(node_3, NumsAdd.addTwoNumbers(node_2, node_1));
    }

    @Test
    public void testNodeLength() {
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4= new ListNode(4);

        node4.next = node3;
        node2.next = node4;
        assertEquals(3, NumsAdd.nodeLength(node2));
    }
}
