package heap;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: heap
 * @ClassName: Heap692
 * @Author: markey
 * @Description:
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *  
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *  
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *  
 *
 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/6 17:31
 * @Version: 1.0
 */
public class Heap692 {

    public static void main(String[] args) {
        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(input, k));
    }

    /**
     * 使用优先队列
     * 执行用时 :48 ms, 在所有 Java 提交中击败了35.65%的用户
     * 内存消耗 :38.8 MB, 在所有 Java 提交中击败了98.88%的用户
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> count = new HashMap<>();
        PriorityQueue<String> minHeap = new PriorityQueue<>((i1, i2) -> {
            if (count.getOrDefault(i1, 0) == count.getOrDefault(i2, 0)) {
                return i1.compareTo(i2);
            }
            return count.getOrDefault(i2, 0) - count.getOrDefault(i1, 0);
        });

        for (String s: words) {
            count.put(s, count.getOrDefault(s,  0) +1);
        }

        for (String x: count.keySet()) {
            minHeap.add(x);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll());
        }
        return result;
    }
}
