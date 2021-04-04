package com.markey.leetcode.seven;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.seven
 * @ClassName: Leetcode721
 * @Author: markey
 * @Description:
 * @Date: 2020/12/25 22:13
 * @Version: 1.0
 */
public class Leetcode721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 因为名字可能相同，所以用序号来表示每条记录,记录每个邮箱和序号的关系
        // 相同邮箱的序号在并查集中合并，查询并查集每个组合的所有邮箱，得到结果
        Union union = new Union(accounts.size());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());
            for (int j = 0; j < emails.size(); j++) {
                String email = emails.get(j);
                if (map.containsKey(email)) {
                    union.union(map.get(email), i);
                } else {
                    map.put(email, i);
                }
            }
        }

        // 遍历每个email（已去重），关联其root
        Map<Integer, List<String>> emails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String email = entry.getKey();
            Integer index = union.get(entry.getValue());
            if (!emails.containsKey(index)) {
                emails.put(index, new ArrayList<>());
            }
            emails.get(index).add(email);
        }

        // 构造结果
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : emails.entrySet()) {
            List<String> item = new ArrayList<>();
            item.add(accounts.get(entry.getKey()).get(0)); // 名字
            Collections.sort(entry.getValue());
            item.addAll(entry.getValue());
            result.add(item);
        }
        return result;
    }

    class Union {
        int[] parent;
        int n;

        public Union(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int get(int i) {
            if (parent[i] != i) {
                parent[i] = get(parent[i]);
            }
            return parent[i];
        }

        public void union(int i, int j) {
            int parentI = get(i);
            int parentJ = get(j);
            if (parentI != parentJ) {
                parent[parentI] = parent[j];
            }
        }
    }
}
