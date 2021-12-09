package competition.day20211024;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211024
 * @ClassName: Leetcode5907
 * @Author: markey
 * @Description:
 * @Date: 2021/10/24 10:59
 * @Version: 1.0
 */
public class Leetcode5907 {
    public static void main(String[] args) {
        Leetcode5907 leetcode5907 = new Leetcode5907();
        System.out.println(leetcode5907.nextBeautifulNumber(3000));
    }
    public int nextBeautifulNumber(int n) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(getNums(Arrays.asList(1)));

        treeSet.addAll(getNums(Arrays.asList(2,2)));
        treeSet.addAll(getNums(Arrays.asList(1,2,2)));

        treeSet.addAll(getNums(Arrays.asList(3,3,3)));
        treeSet.addAll(getNums(Arrays.asList(1,3,3,3)));
        treeSet.addAll(getNums(Arrays.asList(2,2,3,3,3)));
        treeSet.addAll(getNums(Arrays.asList(1,2,2,3,3,3)));

        treeSet.addAll(getNums(Arrays.asList(4,4,4,4)));
        treeSet.addAll(getNums(Arrays.asList(1,4,4,4,4)));
        treeSet.addAll(getNums(Arrays.asList(2,2,4,4,4,4)));
        treeSet.addAll(getNums(Arrays.asList(1,2,2,4,4,4,4)));

        treeSet.addAll(getNums(Arrays.asList(5,5,5,5,5)));
        treeSet.addAll(getNums(Arrays.asList(1,5,5,5,5,5)));

        treeSet.addAll(getNums(Arrays.asList(6,6,6,6,6,6)));

//        System.out.println(treeSet);
        return treeSet.ceiling(n + 1);
    }

    private List<Integer> getNums(List<Integer> nums) {
        if (nums.size() == 1) {
            return Collections.singletonList(nums.get(0));
        }
        List<Integer> res =new ArrayList<>();
        List<Integer> tempNums = new ArrayList<>(nums);
        for (int i = 0; i < tempNums.size(); i++) {
            int now = tempNums.get(i);
            tempNums.remove(i);
            List<Integer> nextNums = getNums(tempNums);
            for(Integer num : nextNums) {
                int temp = (int) ((now * Math.pow(10, tempNums.size())) + num);
                res.add(temp);
            }
            tempNums.add(i, now);
        }
        return res;
    }
}
