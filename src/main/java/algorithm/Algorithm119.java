package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: algorithm
 * @ClassName: Algorithm119
 * @Author: markey
 * @Description:
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/17 22:10
 * @Version: 1.0
 */
public class Algorithm119 {
    /**
     * 杨辉三角形公式 对于杨辉三角的同一行，第 ( i + 1) 项是第 i 项的( k - i ) /( i + 1 ) 倍
     * 要用long类型，int类型不够长
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle II.
     * Memory Usage: 33.5 MB, less than 6.17% of Java online submissions for Pascal's Triangle II.
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>(rowIndex + 1);
        long index = 1;
        for (int i = 0; i <= rowIndex; i++) {
            result.add((int) index);
            index = index * ( rowIndex - i ) / ( i + 1 );
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new Algorithm119().getRow(1);
        System.out.println(result);
    }
}
