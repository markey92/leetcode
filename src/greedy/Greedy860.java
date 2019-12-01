package greedy;

public class Greedy860 {
    /**
     * 题解有人说：贪心体现在每次都尽量选择10元给予找零
     * Runtime: 2 ms, faster than 90.98% of Java online submissions for Lemonade Change.
     * Memory Usage: 40.3 MB, less than 84.62% of Java online submissions for Lemonade Change.
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill: bills) {
            if (bill == 5) {
                five ++;
                continue;
            }
            if (bill == 10 && five > 0) {
                five --;
                ten ++;
                continue;
            }
            if (bill == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                    continue;
                }
                if (five > 2){
                    five -= 3;
                    continue;
                }
            }
            return false;
        }
        return true;
    }

}
