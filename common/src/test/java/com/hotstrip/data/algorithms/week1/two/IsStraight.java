package com.hotstrip.data.algorithms.week1.two;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 *
 * 数组长度为 5
 *
 * 数组的数取值为 [0, 13] .
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class IsStraight {

    @Test
    public void testIsStraight() {
        Assert.assertEquals(true, isStraight(new int[] {1, 2, 3, 4, 5}));
        Assert.assertEquals(true, isStraight(new int[] {0, 0, 1, 2, 5}));
    }

    public boolean isStraight(int[] nums) {
        if (nums.length > 5) {
            return false;
        }
        // 找到数组中最大的数和最小的数，默认需要设置最小值为数组理论存在的最大值，最大值为数组理论存在的最小值
        int min = 13;
        int max = 0;
        // 记录数字是否重复，一共就 1-13 个数字
        boolean[] duplicate = new boolean[14];
        for (int i = 0; i < nums.length; i++) {
            // 如果数字不等于 0 需要判断是否重复
            if (nums[i] != 0 ) {
                // 判断是否重复，不重复就添加到判断重复数组里面，重复肯定不是顺子
                if (duplicate[i]){
                    return false;
                } else {
                    duplicate[i] = true;
                }

                if (nums[i] < min) {
                    min = nums[i];
                }
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
        }
        // 然后判断最大值和最小值的差值，如果小于 5 也肯定不是顺子
        return (max - min) < 5;
    }
}
