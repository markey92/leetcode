package competition.year2020.day20201101;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201101
 * @ClassName: Leetcode5600
 * @Author: markey
 * @Description:
 * @Date: 2020/11/1 11:43
 * @Version: 1.0
 */
public class Leetcode5600 {
    public String kthSmallestPath(int[] destination, int k) {
        int n = destination[0] + destination[1];
        char[] path = new char[n];
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (j < destination[1]) {
                path[j] = 'H';
            } else {
                path[j] = 'V';
            }
        }
        while (--k > 0) {
            move(path);
        }
        return String.valueOf(path);
    }
    //["HHHVV", "HHVHV", "HHVVH", "HVHHV", "HVHVH", "HVVHH", "VHHHV", "VHHVH", "VHVHH", "VVHHH"]
    public void move(char[] path) {
        int index = path.length - 1;
        while (--index > 0) {
            if (path[index] == 'V' && path[index-1] == 'H') {
                path[index] = 'H';
                path[index - 1] = 'V';
                break;
            }
        }
        int start = index;
        int end = path.length - 1;
        while (true) {
            while (start < path.length && path[start] == 'H') {
                start++;
            }
            while (end > 0 && path[end] == 'V') {
                end--;
            }
            if (start < end) {
                path[start] = 'H';
                path[end] = 'V';
            } else {
                break;
            }
        }
    }
}
