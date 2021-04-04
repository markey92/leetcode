package competition.year2020.day20201226;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201226
 * @ClassName: Leetcode5621
 * @Author: markey
 * @Description:
 * @Date: 2020/12/26 22:30
 * @Version: 1.0
 */
public class Leetcode5621 {
    public int countStudents(int[] students, int[] sandwiches) {
        int studentA = 0;
        int studentB = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 1) {
                studentA++;
            } else {
                studentB++;
            }
        }
        int i = 0;
        for (; i < sandwiches.length; i++) {
            if (sandwiches[i] == 1 && studentA > 0) {
                studentA--;
                continue;
            }
            if (sandwiches[i] == 0 && studentB > 0) {
                studentB--;
                continue;
            }
            break;
        }
        return students.length - i;
    }
}
