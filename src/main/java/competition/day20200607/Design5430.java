package competition.day20200607;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200607
 * @ClassName: Design5430
 * @Author: markey
 * @Description:
 * @Date: 2020/6/7 11:06
 * @Version: 1.0
 */
public class Design5430 {
    class BrowserHistory {
        List<String> history;
        int index;
        public BrowserHistory(String homepage) {
            history = new ArrayList<>();
            history.add(homepage);
            index = 0;
        }

        public void visit(String url) {
            history = history.subList(0, index+1);
            history.add(url);
            index++;
        }

        public String back(int steps) {
            index -= steps;
            if (index < 0) {
                index = 0;
            }
            return history.get(index);
        }

        public String forward(int steps) {
            index += steps;
            if (index >= history.size()) {
                index = history.size() - 1;
            }
            return history.get(index);
        }
    }
}
