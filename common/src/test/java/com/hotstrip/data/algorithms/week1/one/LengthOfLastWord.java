package com.hotstrip.data.algorithms.week1.one;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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
@Slf4j
public class LengthOfLastWord {
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
}
