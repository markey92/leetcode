package competition.year2020.day20200503;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200503
 * @ClassName: Map5400
 * @Author: markey
 * @Description:
 * @Date: 2020/5/3 10:31
 * @Version: 1.0
 */
public class Map5400 {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        paths.forEach(path -> map.put(path.get(0), path.get(1)));
        String end = paths.get(0).get(0);
        while (map.containsKey(end)) {
            end = map.get(end);
        }
        return end;
    }
}
