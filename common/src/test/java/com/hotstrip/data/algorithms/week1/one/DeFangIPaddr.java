package com.hotstrip.data.algorithms.week1.one;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

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
@Slf4j
public class DeFangIPaddr {
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
}
