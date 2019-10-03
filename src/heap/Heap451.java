package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: heap
 * @ClassName: Heap451
 * @Author: markey
 * @Description:
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/3 9:47
 * @Version: 1.0
 */
public class Heap451 {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    /**
     * 优先队列做法
     * 执行用时 :73 ms, 在所有 Java 提交中击败了27.06%的用户
     * 内存消耗 :38.5 MB, 在所有 Java 提交中击败了97.10%的用户
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<Character> priorityQueue = new PriorityQueue(
                (i1, i2) -> map.get(i2)- map.get(i1));
        for (char c: map.keySet()) {
            priorityQueue.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            char c = priorityQueue.poll();
            for (int i = 0; i < map.getOrDefault(c, 1); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
