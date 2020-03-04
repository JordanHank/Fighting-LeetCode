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

### 想法

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

### 转换思路

其实没必要把列表的数字全取出来后转换再相加，可以对对应位数的数字直接相加即可。有点类似于二进制的转码和补码，我的想法是这样的，现将列表数据通过递归函数转换成字符串，然后对两个字符串进行加法，长度以较长的字符串稳准，短的字符串高位补0，计算的时候使用堆栈存储每位的数字，算出结果后将堆栈的结果循环取出拼接成字符串，然后再将字符串转为单项队列。

````text
[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
[5,6,4]

---->
    1000000000000000000000000000001
+   0000000000000000000000000000465
------------------------------------------------------------------      
    1000000000000000000000000000466
---->
[6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
````

单项列表转换成字符串：

````java
 public static String node2String(ListNode node) {
    String num1Str = "";
    if (null != node.next) {
        num1Str += node2String(node.next);
    }
    return num1Str += node.val;
}
````

字符串转换成单项列表：

````java
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
````

计算过程：

````java
public static String numsAdd(String num1Str, String num2Str) {
    String min = num1Str.length() > num2Str.length() ? num2Str : num1Str;
    String max = num1Str.length() > num2Str.length() ? num1Str : num2Str;
    Stack<Integer> nums = new Stack<>();
    int forward = 0;
    int minTail = min.length() - 1;
    for (int i = max.length() - 1; i >= 0; i--) {
        int current_min = 0;
        if (minTail > -1) {
            current_min = Integer.valueOf(String.valueOf(min.charAt(minTail)));
        }
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
        minTail--;
    }
    if (forward != 0) {
        nums.push(forward);
    }
    String result = "";
    while(!nums.isEmpty()) {
        result += nums.pop();
    }
    return result.trim();
}
````

### 官解

基本思路和我的想法一致，采用的是初等数学使用变量来跟踪进位，并从包含最低有效位的表头开始模拟逐位相加的过程。

不过代码更简洁：

````java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}
````

### 复杂度分析

+ 时间复杂度：O(\max(m, n))O(max(m,n))，假设 mm 和 nn 分别表示 l1l1 和 l2l2 的长度，上面的算法最多重复 \max(m, n)max(m,n) 次。
+ 空间复杂度：O(\max(m, n))O(max(m,n))， 新列表的长度最多为 \max(m,n) + 1max(m,n)+1。