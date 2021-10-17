package competition.year2021.day20210627;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210627
 * @ClassName: Leetcode5799
 * @Author: markey
 * @Description:
 * @Date: 2021/6/27 11:04
 * @Version: 1.0
 */
public class Leetcode5799 {
    /**
     * 由于我们只关心每个字母出现次数的奇偶性，因此可以将「字母出现次数」转换成「字母出现次数的奇偶性」，这可以用一个长为 1010 的二进制串表示，二进制串的第 ii 位为 00 表示第 ii 个小写字母出现了偶数次，为 11 表示第 ii 个小写字母出现了奇数次。
     *
     * 考虑字母出现次数的前缀和，由于只考虑奇偶性，我们也可以将其视作一个长为 1010 的二进制串。此时计算前缀和由加法运算改为异或运算，这是因为异或运算的本质是在模 22 剩余系中进行加法运算，刚好对应奇偶性的变化。
     *
     * 若有两个不同下标的前缀和相同，则这两个前缀和的异或结果为 00，对应子串的各个字母的个数均为偶数，符合题目要求。因此，我们可以在求前缀和的同时，用一个长为 2^{10}=10242
     * 10
     *  =1024 的 cntcnt 数组统计每个前缀和二进制串出现的次数，从而得到相同前缀和的对数，即各个字母的个数均为偶数的子串个数。
     *
     * 题目还允许有一个字母出现奇数次，这需要我们寻找两个前缀和，其异或结果的二进制数中恰好有一个 11，对应子串的各个字母的个数仅有一个为奇数。对此我们可以枚举当前前缀和的每个比特，将其反转，然后去 cntcnt 中查找该前缀和的出现次数。
     *
     * 将所有统计到的次数累加即为答案。时间复杂度为 O(10\cdot n)O(10⋅n)，nn 为字符串 \textit{word}word 的长度。
     *
     * 作者：endlesscheng
     * 链接：https://leetcode-cn.com/problems/number-of-wonderful-substrings/solution/qian-zhui-he-chang-jian-ji-qiao-by-endle-t57t/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param word
     * @return
     */
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        Map<Integer, Long> states = new HashMap<>();
        states.put(0, 1L);
        int state = 0;long
         res = 0;
        for (int i = 0; i < n; i++) {
            state = state ^ (1 << word.charAt(i) - 'a');
            res += states.getOrDefault(state, 0L); // 全是偶数次
            for (int j = 0; j < 10; j++) {
                // 一个奇数次
                res += states.getOrDefault(state ^ (1 << j), 0L);
            }
            states.put(state, states.getOrDefault(state, 0L) + 1);
        }
        return res;
    }
}
