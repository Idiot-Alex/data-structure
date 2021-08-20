package com.hotstrip.data.algorithms.week1.one;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

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
@Slf4j
public class ReplaceSpace {
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
}
