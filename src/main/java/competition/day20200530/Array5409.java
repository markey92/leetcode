package competition.day20200530;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200530
 * @ClassName: Array5409
 * @Author: markey
 * @Description:
 * @Date: 2020/5/30 22:34
 * @Version: 1.0
 */
public class Array5409 {
    public boolean hasAllCodes(String s, int k) {
        for (int i = 0; i < (1 << k); i++) {
            StringBuilder binaryS = new StringBuilder(Integer.toBinaryString(i));
            while (binaryS.length() < k) {
                binaryS.insert(0, "0");
            }
            System.out.println(binaryS.toString());
            if (s.indexOf(binaryS.toString()) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAllCodes(String s, String[] pre, int k) {
        if (k > 1) {

        }
        for (int i = 0; i < pre.length; i++) {
            String temp1 = pre[i] + 0;
            if (s.indexOf(temp1) < 0) {
                return false;
            }
            String temp2 = pre[i] + 1;
            if (s.indexOf(temp2) < 0) {
                return false;
            }
        }
        return false;
    }
}
