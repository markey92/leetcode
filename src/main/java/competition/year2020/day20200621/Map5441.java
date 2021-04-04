package competition.year2020.day20200621;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200621
 * @ClassName: Map5441
 * @Author: markey
 * @Description:
 * @Date: 2020/6/21 10:34
 * @Version: 1.0
 */
public class Map5441 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                map.put(name, 1);
                continue;
            }
            int index = map.get(name);
            String newName = name;
            while (map.containsKey(newName)) {
                newName = name + "(" + index + ")";
                index++;
            }
            names[i] = newName;
            map.put(name, index);
            map.put(newName, 1);
        }
        System.out.println(map);
        return names;
    }
}
