package com.hotstrip.data.algorithms.week1.one;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

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
@Slf4j
public class IsPalindromeString {
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
}
