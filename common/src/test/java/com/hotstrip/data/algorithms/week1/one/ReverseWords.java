package com.hotstrip.data.algorithms.week1.one;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

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
@Slf4j
public class ReverseWords {
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
}
