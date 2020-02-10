package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack402
 * @Author: markey
 * @Description:
 * @Date: 2020/2/10 22:37
 * @Version: 1.0
 */
public class Stack402 {
    /**
     * 思路同官方题解
     * 给定一个数字序列，例如 425，如果要求我们只删除一个数字，那么从左到右，我们有 4、2 和 5 三个选择。我们将每一个数字和它的左邻居进行比较。
     * 从 2 开始，小于它的左邻居 4。则我们应该去掉数字 4。如果不这么做，则随后无论做什么（后续不管移除2还是4，都是4开头的，不是最小，最小应该是2开头），都不会得到最小数。
     * 【D1，D2，D3，D4】如果D1比D2大，则移除D1，结束，进行下一次移除，否则比较D2和D3.
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        List<Integer> list = new ArrayList<>();
        for(char c: num.toCharArray()) {
            list.add(Integer.parseInt(String.valueOf(c)));
        }
        // 要移除k个数字，就比较k次
        for (int i = 0; i < k; i++) {
            // 从左往右比较每一对数字，例如 （0，1），（1，2），如果有前一个数比后一个数大，就移除这个数，结束循环。
            // 边界：到达最后一个数的时候，都没有符合情况的，说明这是一个递增数，就移除最后一位
            for (int j = 0; j < list.size(); j++) {
                if (j == list.size() - 1) {
                    list.remove(j);
                    break;
                }
                if (list.get(j) > list.get(j + 1)) {
                    list.remove(j);
                    break;
                }
            }
        }
        // 构造结果
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;
        for (int i = 0; i < list.size(); i++) {
            if (!isStart || list.get(i) != 0 || i == list.size() - 1) {
                isStart = false;
                sb.append(list.get(i));
            }
        }
        return list.size() == 0 ? "0" : sb.toString();
    }
}
