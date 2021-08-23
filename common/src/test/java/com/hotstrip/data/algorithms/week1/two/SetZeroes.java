package com.hotstrip.data.algorithms.week1.two;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class SetZeroes {

    @Test
    public void testSetZeroes() {
        int[][] matrix = new int[][] {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        setZeroes(matrix);
        print(matrix);

        matrix = new int[][] {
                {1,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(matrix);
        print(matrix);
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return;
        int n = matrix[0].length;
        // 扫描整个数组，记录需要设置为 0 的行和列
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 一旦等于 0 就设置对应的行和列
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // 遍历数组，比较当前元素的位置是否需要设置为 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 一旦等于 0 就设置对应的行和列
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
