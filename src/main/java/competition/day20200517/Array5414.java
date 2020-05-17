package competition.day20200517;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200517
 * @ClassName: Array5414
 * @Author: markey
 * @Description:
 * @Date: 2020/5/17 10:57
 * @Version: 1.0
 */
public class Array5414 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> big = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            if (big.size() == 0) {
                big.add(i);
                continue;
            }
            boolean isNewBig = true;
            Iterator<Integer> iterator = big.iterator();
            while (iterator.hasNext()) {
                Integer index = iterator.next();
                if (isSub(favoriteCompanies.get(i), favoriteCompanies.get(index))) {
                    isNewBig = false;
                    break;
                }
                if (isSub(favoriteCompanies.get(index), favoriteCompanies.get(i))) {
                    iterator.remove();
                }
            }
            if (isNewBig) {
                big.add(i);
            }
            System.out.println(big);
        }
        return big;
    }

    private boolean isSub(List<String> a, List<String> b) {
        if (a.size() >= b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!b.contains(a.get(i))) {
                return false;
            }
        }
        System.out.println(a + "is sub of" + b);
        return true;
    }
}
