package bit;

/**
 * @ProjectName: leetcode
 * @Package: bit
 * @ClassName: Bit16_07
 * @Author: markey
 * @Description:
 * @Date: 2020/6/1 21:49
 * @Version: 1.0
 */
public class Bit16_07 {
    public int maximum(int a, int b) {
        //方法1：使用两个数相减的正负号 ，来确定大小
        //a-b两数相减二进制首位是符号：若首位是0，则a大，返回arr[0],即a;否则首位是1,说明b返回arr[1]
        //求首位：(a-b）>>>63 (无符号移63位，将首位，也就是符号位移到最后)
        //a-b可能回数值过大，int 无法表示，转为long
        //  int  [] arr={a,b};
        //  return arr[(int)(((long)a - b)>>> 63)];

        //方法2：根据提示求，k
        // int k = (int)(((long)a - (long)b) >> 63) & 1;//得符号位，若为1：说明是负数，a小，b 大
        int k = (int)(((long)a - (long)b) >>> 63);
        return b * k + a * (k ^ 1);//0或1
    }
}
