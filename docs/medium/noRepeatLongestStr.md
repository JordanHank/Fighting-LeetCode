## 无重复字符的最长子串

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

**示例1：**

````text
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
````

**示例2：**

````text
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
````

**示例3：**

````text
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
````

### 思路

将字符串的每个字符依次取出来和后面的剩余字符进行对比，看后面字符串中是否含有当前字符，如果有将字符串根据两次出现字符的下标进行拆分，取拆分后的字符串长度较长的进行递归计算，知道没有字符重复位置；如果剩余字符串中没有当前字符，继续循环长度加1，记录下来循环拼接出来的无重复字符的字符串，最后计算该字符串的长度则为无重复的最长字符串。

```text
pwwkew
------------
循环p-> wwkew 剩余字符串
pw wkew
-> 出现相邻字符串相同的情况取后面
wkew
------------
含有w-> 拆分字符串w kew
取较长的字符串（较长的字符串出现无重复的字符串长度最大的可能性更高）
-> wke递归
w ke
wk e
wke
------------
得到结果3

```

代码：

````java
public static int lengthOfLongestSubstring(String s) {
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
````

提交了几次代码都没有通过测试，说明这个思路有问题或者写法有问题。

### 优化思路

之前的问题出在拆分了字符串之后想当然的以为字符串长度更长的肯定会出现无重复最长的字符串，但是其实并不是，所以没有必要纠结应该取那个子串取计算无重复的字符串，直接想拆分后的字符串递归处理选出无重复子串长度最长的就好。

代码：

```
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
```

### 官解

由于官方给出的答案比较细致，内容也比较多，这里直接给出链接，有兴趣的可以自己去查看，后面关于官解内容都已链接为主。

>[无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/)

