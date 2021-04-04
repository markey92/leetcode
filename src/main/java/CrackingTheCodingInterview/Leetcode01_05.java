package CrackingTheCodingInterview;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode07_05
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 17:31
 * @Version: 1.0
 */
public class Leetcode01_05 {
    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return changeOne(first, second);
        } else if (first.length() - second.length() == 1) {
            return addOne(second, first);
        } else if (first.length() - second.length() == -1) {
            return addOne(first, second);
        } else {
            return false;
        }
    }

    public boolean addOne(String first, String second) {
        System.out.println(first);
        System.out.println(second);
        int addNum = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i + addNum)) {
                addNum++;
                i--; // 当前字符需要与下个字符比较
            }
            if (addNum > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean changeOne(String first, String second) {
        int changeNum = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                changeNum++;
            }
            if (changeNum > 1) {
                return false;
            }
        }
        return true;
    }
}
