package competition.year2021.day20211128;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.year2021.day20211128
 * @ClassName: Leetcode5941
 * @Author: markey
 * @Description:
 * @Date: 2021/11/28 10:52
 * @Version: 1.0
 */
public class Leetcode5941 {
    public static void main(String[] args) {
        Leetcode5941 leetcode5941 = new Leetcode5941();
        int[][] meetings = new int[][] {{1,2,5},{2,3,8},{1,5,10}};
        int n = 6;
        int firstPerson = 1;
        System.out.println(leetcode5941.findAllPeople(n, meetings, firstPerson));
    }

    // 超时
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // 记录每个时刻的会议
        TreeMap<Integer, List<int[]>> timeMeetings = new TreeMap<>();
        for (int i = 0; i < meetings.length; i++) {
            if (!timeMeetings.containsKey(meetings[i][2])) {
                timeMeetings.put(meetings[i][2], new ArrayList<>());
            }
            timeMeetings.get(meetings[i][2]).add(meetings[i]);
        }
        UnionFind unionFind = new UnionFind(n);
        unionFind.union(0, firstPerson);
        while (!timeMeetings.isEmpty()) {
            List<int[]> nowMeetings = timeMeetings.pollFirstEntry().getValue();
            for(int[] meeting : nowMeetings) {
                unionFind.union(meeting[0], meeting[1]);
            }
            for(int[] meeting : nowMeetings) {
                // 不知道秘密的人相当于没有开过会，所以他们不属于任何团队
                if (unionFind.find(meeting[0]) != 0) {
                    unionFind.separate(meeting[0]);
                }
                if (unionFind.find(meeting[1]) != 0) {
                    unionFind.separate(meeting[1]);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (unionFind.find(i) == 0) {
                res.add(i);
            }
        }
        return new ArrayList<>(res);
    }

    class UnionFind {
        // 只有一个团队是知道秘密的，他们的parent是0；
        int[] parent;
        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public Set<Integer> getKnownPersonParent(Set<Integer> knownPersons) {
            Set<Integer> knowPersonParents = new HashSet<>();
            for (int konwnPerson : knownPersons) {
                knowPersonParents.add(find(konwnPerson));
            }
            return knowPersonParents;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == 0 || parentY == 0) {
                // 其中一个小团队是知道秘密的团队，则两个小团队都加入知道秘密的团队
                parent[parentX] = 0;
                parent[parentY] = 0;
            } else {
                // 不知道秘密的小团队
                parent[parentX] = parentY;
            }
        }

        public void separate(int x) {
            parent[x] = x;
        }
    }
}
