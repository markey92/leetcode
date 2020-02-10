package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: other
 * @ClassName: Class5334
 * @Author: markey
 * @Description:
 * @Date: 2020/2/9 10:56
 * @Version: 1.0
 */
public class Class5334 {
    class TweetCounts {
        List<Order> list;
        public TweetCounts() {
            list = new ArrayList<>();
        }

        public void recordTweet(String tweetName, int time) {
            list.add(new Order(tweetName, time));
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            List<Integer> res = new ArrayList<>();
            int range = 60;
            if (freq.equals("hour")) {
                range = 3600;
            } else if (freq.equals("day")) {
                range = 21600;
            }
            int index = (endTime - startTime) / range  + 1;
            for (int i = 0; i < index; i++) {
                int time = 0;
                for (Order order: list) {
                    if (order.tweetName.equals(tweetName)
                            && order.time >= startTime + range * i
                            && order.time < startTime + range * (i + 1)
                            && order.time <= endTime) {
                        time++;
                    }
                }
                res.add(time);
            }
            return res;
        }

        class Order {
            public String tweetName;
            public int time;
            public Order(String tweetName, int time) {
                this.tweetName = tweetName;
                this.time = time;
            }
        }
    }

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
}
