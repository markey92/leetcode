package competition.year2020.day20200816;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200816
 * @ClassName: Leetcode5489
 * @Author: markey
 * @Description:
 * @Date: 2020/8/16 11:02
 * @Version: 1.0
 */
public class Leetcode5489 {
    /**
     * 思路：二分搜索
     * 题意求最大化最小，类似这样的求最大化最小值、最小化最大值等都可以用二分搜索解决。
     *
     * 实现细节：
     * 首先要找到二分搜索的边界，根据题意，要返回的是最小磁力，所以第一步要找到最小磁力的最小可能取值和最大可能取值。
     *
     * 对于最小可能取值，当然就是给定数组中距离最近的两个位置之间的磁力，所以对数组进行排序，并遍历数组找到相邻两个位置的最小距离。
     *
     * 对于最大可能取值，一共有m个球，所以有 m - 1 个间隔，最大的可能取值便是最平均的取值，所以根据给定数组最大值与最小值之差与间隔数的比值计算出平均距离，就是给定的最大可能取值。
     *
     * 这里给定简单证明，假设有 k 个间隔，给定数组规定的篮子间最大距离为 x，那么最小磁力的最大可能取值是 x / k，假设有某一可能取值 y 大于最大可能取值，那么所有距离都一定大于等于 y，此时假设 k 个间隔距离均为 y，总距离 ky > k * x / k = x，也大于给定的最大距离，所以不成立。
     *
     * 确定好了边界后，每次二分搜索时需要判断当前计算值是否满足条件，这里我们引入 check 函数，对当前计算出的最小磁力进行验证。验证过程使用贪心算法，遍历数组，若找到两位置之间距离大于等于最小磁力，则计数值加1，最后只需要判断总计数值是否大于等于给定间隔数 m - 1即可。
     *
     * 例如，示例1中，假设我们当前二分搜索计算出的距离为 2，那么我们遍历数组，假设第一个位置为 1，那么下一个找到的位置应该是3，因为 3 - 1 >= 2，计数值加1；再下面找到的是 7，因为 7 - 3 >= 2，计数值加1。此时数组遍历完成，总计数值为 2，而给定间隔数 m - 1 = 2，满足条件，说明最小磁力为2是可以做到的。但如果我们当前计算出的距离为4，那么第一个位置为1，找到的第二个位置就只能是7，数组遍历完成总计数值为1，小于给定间隔数，说明最小磁力为4是不成立的。
     *
     * 在判断计算值满足条件与否之后，我们要对二分搜索边界进行转化，由于题目要求的是最大化的最小磁力，所以若当前计算出的最小磁力满足条件，我们要将左边界右移，去判断稍大一点的数值是否满足条件；若当前计算出的最小磁力不满足条件，我们要将右边界左移，判断稍小的数值是否满足条件。
     *
     * 由于每次满足条件后左边界右移，所以左边界的左边一个数值是一定满足条件的，所以最后返回值为 l - 1，具体返回值根据边界移动的判定规则进行判断。
     *
     * 作者：bndsbilly
     * 链接：https://leetcode-cn.com/problems/magnetic-force-between-two-balls/solution/c-er-fen-sou-suo-ying-gai-neng-gei-ni-jiang-ming-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param position
     * @param m
     * @return
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int max = (position[n - 1] - position[0]) / (m - 1);

        int min = max;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, position[i] - position[i - 1]);
        }
        System.out.println(min + " vs " + max);
        while (min < max) {
            int middle = (max + min) / 2;
            System.out.println(middle);
            if (check(position, middle, m - 1)) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }
        return max;
    }

    private boolean check(int[] position, int diff, int num) {
        int count = 0;
        for (int i = 1, j = 0; i < position.length; i++) {
            if (position[i] - position[j] >= diff) {
                count++;
                j = i;
            }
        }
        return count >= num;
    }
}
