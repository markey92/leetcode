package competition.year2020.day20200705;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200705
 * @ClassName: String5455
 * @Author: markey
 * @Description:
 * @Date: 2020/7/5 11:40
 * @Version: 1.0
 */
public class String5455 {
//    public String minInteger(String num, int k) {
//        if (num.length() == 0 || k <= 0) {
//            return num;
//        }
//        int minIndex = findMinIndex(num);
//        String res = "";
//        if (minIndex <= k) {
//            char[] chars = num.toCharArray();
//            char temp = chars[minIndex];
//            chars[minIndex] = '';
//            chars[0] = temp;
//            num = new String(chars);
//            res = temp + minInteger(num.substring(1), k - minIndex);
//        } else {
//            res = minInteger(num.substring(0, minIndex), k) + num.substring(minIndex);
//        }
//        return res;
//    }
//    private int findMinIndex(String num) {
//        if (num.length() == 0) {
//            return 0;
//        }
//        int res = 0;
//        char temp = num.charAt(0);
//        for (int i = 1; i < num.length(); i++) {
//            if (num.charAt(i) < temp) {
//                temp = num.charAt(i);
//                res = i;
//            }
//        }
//        return res;
//    }
}
