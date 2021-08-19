package com.hotstrip.data.structure.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class TestLeetCode1 {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *  
     *
     * 提示：
     *
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void testTwoSum() {
        log.info("{}", twoSum(new int[] {2, 7, 11, 15}, 9));
        log.info("{}", twoSum(new int[] {3, 2, 4}, 6));
        log.info("{}", twoSum(new int[] {3, 3}, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        // 双重遍历数组，判断两个数的和是否等于 target
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }


    /**
     * 判断是否是回文数，从左往右读取和从右往左读取数字结果相同
     * 121 true
     * -121 false
     * 999 true
     * 86568 true
     */
    @Test
    public void testIsPalindrome() {
        boolean flag = isPalindrome(8);
        log.info("result is: {}", flag);
        Assert.assertEquals(true, flag);

        flag = isPalindrome(100);
        log.info("result is: {}", flag);
        Assert.assertEquals(false, flag);

        flag = isPalindrome(-80);
        log.info("result is: {}", flag);
        Assert.assertEquals(false, flag);

        flag = isPalindrome(818);
        log.info("result is: {}", flag);
        Assert.assertEquals(true, flag);
    }

    public boolean isPalindrome(int x) {
        // 负数不会是回文数
        if (x < 0) {
            return false;
        }
        // 把数字转换成字符串数组，遍历首尾对应的下标，判断是否相等
        char[] array = String.valueOf(x).toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
     *
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "Hello World"
     * 输出：5
     * 示例 2：
     *
     * 输入：s = "   fly me   to   the moon  "
     * 输出：4
     * 示例 3：
     *
     * 输入：s = "luffy is still joyboy"
     * 输出：6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/length-of-last-word
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void testLengthOfLastWord() {
        log.info("{}", lengthOfLastWord("Hello World"));
        log.info("{}", lengthOfLastWord("   fly me   to   the moon  "));
    }
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean flag = false;
        // 转换成字符数组，从后往前遍历，找到第一个不为 ' ' 的下标，累加到下一个为 ' '为止
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                count++;
                flag = true;
            }
            if (flag && chars[i] == ' ') {
                break;
            }
        }
        // 返回长度
        return count;
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 解释："amanaplanacanalpanama" 是回文串
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     * 解释："raceacar" 不是回文串
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * ASCII 码表
     * a-z：97-122
     * A-Z：65-90
     * 0-9：48-57
     */
    @Test
    public void testIsPalindromeStr() {
        Assert.assertEquals(false, isPalindrome(""));
        Assert.assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertEquals(false, isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        // 先去掉非数字和字母的字符，用 ASCII 码
        StringBuilder builder = new StringBuilder("");
        for (char c : s.toCharArray()) {
            if ((48 <= c && c <= 57) || (65 <= c && c <= 90) || (97 <= c && c <= 122)) {
                builder.append(c);
            }
        }
        log.info("{}", builder.toString());
        // 然后判断是否是回文字符串，字符数组，遍历首尾对应的下标，判断是否相等(需要注意忽略大小写)
        char[] array = builder.toString().toLowerCase().toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * 示例 2：
     *
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void testReverseString() {
        char[] chars = new char[] {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        log.info("{}", chars);

        chars = new char[] {'h', 'a', 'n', 'n', 'a', 'h'};
        reverseString(chars);
        log.info("{}", chars);
    }

    public void reverseString(char[] s) {
        char temp;
        // 遍历数组，交换首尾相对应的字符，用临时变量存储
        for (int i = 0; i <s.length / 2 ; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 -i];
            s[s.length - 1 -i] = temp;
        }
    }

    /**
     * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
     *
     * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：address = "1.1.1.1"
     * 输出："1[.]1[.]1[.]1"
     * 示例 2：
     *
     * 输入：address = "255.100.50.0"
     * 输出："255[.]100[.]50[.]0"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/defanging-an-ip-address
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void testDefangIPaddr() {
        Assert.assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"));
        Assert.assertEquals("255[.]100[.]50[.]0", defangIPaddr("255.100.50.0"));
    }

    public String defangIPaddr(String address) {
        // 字符串转换成字符数组，遍历，检测到 . 就替换成 [.]
        StringBuilder builder = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                builder.append("[.]");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *  
     *
     * 限制：
     *
     * 0 <= s 的长度 <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void testReplaceSpace() {
        Assert.assertEquals("We%20are%20happy.", replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        // 遍历字符数组，匹配空格，然后替换字符串
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     *
     *  
     *
     * 示例 1：
     *
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * 示例 2：
     *
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     *
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *  
     *
     * 说明：
     *
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * 注
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void testReverseWords() {
        Assert.assertEquals("blue is sky the", reverseWords("the sky is blue"));
        Assert.assertEquals("world! hello", reverseWords("  hello world!  "));
        Assert.assertEquals("example good a", reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        // 去掉首尾空格
        s = s.trim();
        // 先根据空格分割字符串，然后忽略为空的子字符串，最后倒序拼接
        String[] strings = s.split("\\s+");
        for (int i = strings.length - 1; i >= 0; i--) {
            // 忽略为空的子字符串
            if (!" ".equals(strings[i])) {
                builder.append(strings[i]);
                // 如果不是最后一个，就添加空格
                if (i > 0) {
                    builder.append(" ");
                }
            }
        }
        return builder.toString();
    }

    /**
     * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
     *
     *  
     *
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     *
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     *
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     *
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     *
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void testStrToInt() {

    }

    public int strToInt(String str) {
        return 0;
    }

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     *  
     *
     * 说明:
     *
     * 为什么返回数值是整数，但输出的答案是数组呢?
     *
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *  
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     *
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     *  
     *
     * 提示：
     *
     * 0 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums 已按升序排列
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void testRemoveDuplicates() {
        Assert.assertEquals(2, removeDuplicates(new int[]{1, 1, 2}));
        Assert.assertEquals(5, removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        Assert.assertEquals(6, removeDuplicates(new int[]{3, 4, 4, 4, 4, 4, 5, 6, 6, 6, 6, 6, 8, 8, 10}));
    }

    public int removeDuplicates(int[] nums) {
        // 边界条件 数组数量不为 0
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        // 遍历数据
        for (int i = 1; i < nums.length; i++) {
            // 如果当前值不等于上一个值
            if (nums[index] != nums[i]) {
                // 更新上一个不重复的下标的值
                index ++;
                // 上一个不重复的下标修改成当前的值
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }


}
