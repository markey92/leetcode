package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array275
 * @Author: markey
 * @Description:
 * @Date: 2020/5/29 22:48
 * @Version: 1.0
 */
public class Array275 {
    public int hIndex(int[] citations) {
        int max = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > max) {
                max++;
            } else {
                break;
            }
        }
        return max;
    }
}
