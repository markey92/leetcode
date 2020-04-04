package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array119
 * @Author: markey
 * @Description:119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * @Date: 2020/4/4 12:00
 * @Version: 1.0
 */
public class Array119 {
    public List<Integer> getRow(int rowIndex) {

        int[] result = new int[rowIndex];
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i || j == 0) {
                    result[j] = 1;
                } else {
                    result[j] = result[j] + result[j-1];
                }
            }
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
