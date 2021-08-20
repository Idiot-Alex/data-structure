package com.hotstrip.data.algorithms.week1.one;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * 判断是否是回文数，从左往右读取和从右往左读取数字结果相同
 * 121 true
 * -121 false
 * 999 true
 * 86568 true
 */
@Slf4j
public class IsPalindrome {
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
}
