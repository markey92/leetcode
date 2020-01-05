package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array1128
 * @Author: markey
 * @Description:
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *  
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/18 0:32
 * @Version: 1.0
 */
public class Array1128 {

    /**
     * Runtime: 8 ms, faster than 80.24% of Java online submissions for Number of Equivalent Domino Pairs.
     * Memory Usage: 55.6 MB, less than 100.00% of Java online submissions for Number of Equivalent Domino Pairs.
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int[] array: dominoes) {
            int key = Math.max(array[0], array[1]) * 10 + Math.min(array[0], array[1]);
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        int result = 0;
        for (int key: count.keySet()) {
            result += count.get(key) * (count.get(key) - 1) / 2;
        }
        return result;
    }
}
