package com.markey.leetcode.one;

import java.util.LinkedHashMap;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode146
 * @Author: markey
 * @Description:
 * @Date: 2021/10/17 15:57
 * @Version: 1.0
 */
public class Leetcode146 {
    class LRUCache {

        private LinkedHashMap<Integer, Integer> cache;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                int value = cache.get(key);
                cache.remove(key);
                cache.put(key, value);
                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.remove(key);
            }
            if (cache.size() >= capacity) {
                cache.remove(cache.entrySet().iterator().next().getKey());
            }
            cache.put(key, value);
        }
    }
}
