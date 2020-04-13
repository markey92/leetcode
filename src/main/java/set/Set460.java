package set;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: map
 * @ClassName: Map460
 * @Author: markey
 * @Description:460. LFU缓存
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 * 示例：
 *
 * LFUCache cache = new LFUCache( 2 capacity (缓存容量) );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回 1
        *cache.put(3,3);    // 去除 key 2
        *cache.get(2);       // 返回 -1 (未找到key 2)
        *cache.get(3);       // 返回 3
        *cache.put(4,4);    // 去除 key 1
        *cache.get(1);       // 返回 -1 (未找到 key 1)
        *cache.get(3);       // 返回 3
        *cache.get(4);       // 返回 4
        *通过次数3,747提交次数10,460
        *
        *来源：力扣（LeetCode）
        *链接：https://leetcode-cn.com/problems/lfu-cache
        *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/5 10:06
 * @Version: 1.0
 */
public class Set460 {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        System.out.println("output" + lfuCache.get(2));
        lfuCache.put(2, 6);
        System.out.println("output" + lfuCache.get(1));
        lfuCache.put(1, 5);
        lfuCache.put(1, 2);
        System.out.println("output" + lfuCache.get(1));
        System.out.println("output" + lfuCache.get(2));
    }
    static class LFUCache {
        // 出现频率的集合
        Map<Integer, List<Integer>> frequencics;
        // key出现的频率
        Map<Integer, Integer> frequency;
        // key-value
        Map<Integer, Integer> values;
        int capacity;
        public LFUCache(int capacity) {
            this.frequency = new HashMap<>();
            this.frequencics = new TreeMap<>();
            this.values = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if (!values.containsKey(key)) {
                return -1;
            }
            int value = values.get(key);
            int frequencyX = frequency.get(key);
            this.delete(key);
            this.add(key, value, frequencyX+1);
            return value;
        }

        public void put(int key, int value) {
            if (this.capacity == 0) {
                return;
            }
            if (this.values.containsKey(key)) {
                // key已存在，则其值要改变，频率要加1
                int frequencyX = frequency.get(key);
                this.delete(key);
                this.add(key, value, ++frequencyX);
            } else if (this.values.size() == this.capacity) {
                // key不存在，达到容量限额，需要删除LFU，后再插入
                int lfu = (int) this.frequencics.keySet().toArray()[0];
                int lfuKey = this.frequencics.get(lfu).get(0);
                this.delete(lfuKey);
                this.add(key, value, 1);
            } else {
                this.add(key, value, 1);
            }
            System.out.println("frequencics:"+frequencics);
        }

        private void delete(int key) {
            // 删除值
            this.values.remove(key);
            // 删除频率记录
            int frequencyX = this.frequency.get(key);
            this.frequency.remove(key);
            // 删除该频率下这个key的记录
            List list = this.frequencics.get(frequencyX);
            list.remove(list.indexOf(key));
            if (list.isEmpty()) {
                this.frequencics.remove(frequencyX);
            }
        }

        private void add(int key, int value, int frequency) {
            // 插入key-value
            this.values.put(key, value);
            // 记录key的频率
            this.frequency.put(key, frequency);
            // 频率集合中加上这个key
            if (!this.frequencics.containsKey(frequency)) {
                this.frequencics.put(frequency, new ArrayList<>());
            }
            this.frequencics.get(frequency).add(key);
        }
    }
}
