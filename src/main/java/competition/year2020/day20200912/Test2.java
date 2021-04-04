package competition.year2020.day20200912;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200912
 * @ClassName: Test2
 * @Author: markey
 * @Description:
 * @Date: 2020/9/12 15:03
 * @Version: 1.0
 */
public class Test2 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        long res = 0;
        int indexOfDrink = drinks.length - 1;
        for (int i = 0; i < staple.length; i++) {
            int stapleNow = staple[i];
            if (stapleNow > x) {
                break;
            }
            while (indexOfDrink >= 0 && drinks[indexOfDrink] + stapleNow > x) {
                indexOfDrink--;
            }
            System.out.println(indexOfDrink);
            res += indexOfDrink + 1;
            res %= 1000000007;
        }
        return (int) res;
    }
}
