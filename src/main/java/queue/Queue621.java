package queue;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: queue
 * @ClassName: Queue621
 * @Author: markey
 * @Description:
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * 示例 1：
 *
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 注：
 *
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/6 19:51
 * @Version: 1.0
 */
public class Queue621 {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
    public static int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> taskList = new HashMap<>();
        int max = 0;
        int maxType = 0;
        for (char c: tasks) {
            taskList.put(c, taskList.getOrDefault(c, 0) + 1);
            if (taskList.get(c) == max) {
                maxType ++ ;
            }
            if (taskList.get(c) > max) {
                max = taskList.get(c);
                maxType = 1;
            }
        }
        //前n-1个桶中能放下多少元素
        int used = (max - 1) * (n + 1);
        if (tasks.length >= used + n + 1) {
            //说明n个桶都无法放下所有元素，则结果是n个桶放满，剩下的任务随意放都可以
            return tasks.length;
        } else {
            //说明n个桶都放下所有元素后还有剩余
            int last = tasks.length - used;
            //因为maxtype种类型的任务必须放在不同的桶中，所以最后一个桶的任务数最少是maxType；
            if (maxType > last) last = maxType;
            return (max - 1) * (n + 1) + last;
        }
    }
}
