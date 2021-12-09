package test.test20211204;

/**
 * @ProjectName: leetcode
 * @Package: test.test20211204
 * @ClassName: Test2
 * @Author: markey
 * @Description:
 * @Date: 2021/12/4 21:25
 * @Version: 1.0
 */
public class Test2 {
    public String strWithout3a3b(int a, int b) {
        return a > b ? strWithout3a3b(a, "a", b, "b") : strWithout3a3b(b, "b", a, "a");
    }

    public String strWithout3a3b(int a, String x, int b, String y) {
        StringBuilder stringBuilder = new StringBuilder();
        while (a > 0 || b > 0) {
            if (a == 0) {
                for (int i = 0; i < b; i++) {
                    stringBuilder.append(y);
                }
                break;
            }
            if (b == 0) {
                for (int i = 0; i < a; i++) {
                    stringBuilder.append(x);
                }
                break;
            }
            if (a > b) {
                stringBuilder.append(x).append(x);
                a -= 2;
                stringBuilder.append(y);
                b -= 1;
            } else if (b > a) {
                stringBuilder.append(x);
                a -= 1;
                stringBuilder.append(y).append(y);
                b -= 2;
            } else {
                stringBuilder.append(x);
                a -= 1;
                stringBuilder.append(y);
                b -= 1;
            }
        }
        return stringBuilder.toString();
    }
}
