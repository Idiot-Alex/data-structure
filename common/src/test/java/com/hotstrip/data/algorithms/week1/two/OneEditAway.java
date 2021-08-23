package com.hotstrip.data.algorithms.week1.two;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class OneEditAway {

    @Test
    public void test() {
        Assert.assertEquals(true, oneEditAway("pale", "ple"));
        Assert.assertEquals(false, oneEditAway("pales", "pal"));
    }

    public boolean oneEditAway(String first, String second) {
        // 两个字符串要么相同长度，要么长度相差不能大于 1
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        // 两个字符串的字符肯定最多只有一个不一样，可以是当前这个
        int count = 0;
        // 如果两个字符串长度不一样，count 从 1 开始
//        if (first.length() != second.length()) {
//            count = 1;
//        }
//        int len = Math.min(first.length(), second.length());
//        for (int i = 0; i < len; i++) {
//            if (first.charAt(i) != second.charAt(i)) {
//                count++;
//            }
//        }

        // 判断字符不一样的个数
        return count <= 1;
    }
}
