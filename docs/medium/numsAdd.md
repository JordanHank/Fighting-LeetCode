## 两数相加

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

**示例：**

````text
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
````

## 想法

简单想法是将单项列表ListNode 转换成数字然后进行计算，再把计算的结果转换成单项列表 ListNode。


列表转数字：

````java
 public static int node2Long(ListNode node) {
    String num1Str = "";
    if (null != node.next) {
        num1Str += node2Long(node.next);
    }
    num1Str += node.val;
    return Integer.valueOf(num1Str);
}
````

数字转列表：

````java
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
````

跑提供的测试用例的时候正确：

````text
[2,4,3]
[5,6,4]
````

结果

```
[7,0.8]
```

但是提交的时候没有通过：

````text
[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
[5,6,4]
````

报错信息：

````text
java.lang.NumberFormatException: For input string: "10000000000000000000"
  at line 68, java.base/java.lang.NumberFormatException.forInputString
  at line 699, java.base/java.lang.Long.parseLong
  at line 1151, java.base/java.lang.Long.valueOf
  at line 23, Solution.node2Long
  at line 20, Solution.node2Long
  at line 20, Solution.node2Long
  at line 20, Solution.node2Long
  at line 20, Solution.node2Long
  at line 20, Solution.node2Long
  at line 20, Solution.node2Long
  at line 20, Solution.node2Long
  at line 20, Solution.node2Long
  at line 20, Solution.node2Long
  at line 20, Solution.node2Long
  at line 20, Solution.node2Long
  at line 11, Solution.addTwoNumbers
  at line 57, __DriverSolution__.__helper__
  at line 87, __Driver__.main
````

发现这个通过字符串转换成数字的时候超出了Long 的存储范围，所以报了类型转换错误。

## 转换思路

其实没必要把列表的数字全取出来后转换再相加，可以对对应位数的数字直接相加即可。

