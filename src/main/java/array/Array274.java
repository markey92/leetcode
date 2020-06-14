package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array274
 * @Author: markey
 * @Description:
 * @Date: 2020/5/29 22:36
 * @Version: 1.0
 */
public class Array274 {
    public int hIndex(int[] citations) {
        citations = Arrays.stream(citations).boxed().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= i + 1) {
                max++;
            } else {
                break;
            }
        }
        return max;
    }
}
