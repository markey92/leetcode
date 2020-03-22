package bit;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: bit
 * @ClassName: BaseOperator
 * @Author: markey
 * @Description:
 * @Date: 2020/3/14 22:03
 * @Version: 1.0
 */
public class BaseOperator {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        int a = 1;
        map.put(1,1);
        Set set = map.keySet();
        System.out.println(set);
        set.remove(a);
        System.out.println(set);
//        System.out.println(remainder(99, 2)); // 10除以4的余数
    }
    // 当被除数是2的幂时求余，举例：hashmap中用来确定桶的位置
    public static int remainder(int a, int b) {
        return (b - 1) & a;
    }
}
