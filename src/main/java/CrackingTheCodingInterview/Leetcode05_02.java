package CrackingTheCodingInterview;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode05_02
 * @Author: markey
 * @Description:
 * @Date: 2020/10/25 21:30
 * @Version: 1.0
 */
public class Leetcode05_02 {
    public String printBin(double num) {
        if (num <=0 || num >= 1) {
            // 题目要求特殊情况
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder("0.");
        while (num > 0 && sb.length() < 34) { // 32位二进制
            num *= 2;
            System.out.println(num);
            sb.append(num >= 1 ? 1 : 0); // 取整数
            num -= num >= 1 ? 1 : 0; // 去整数部分
        }
        return sb.length() < 32 ? sb.toString() : "ERROR";
    }
}
