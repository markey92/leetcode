package competition.year2021.day20211114;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211114
 * @ClassName: Leetcode5929
 * @Author: markey
 * @Description:
 * @Date: 2021/11/14 11:46
 * @Version: 1.0
 */
public class Leetcode5929 {

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind unionFind = new UnionFind(n);
        boolean[] res = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            UnionFind unionFindCopy = new UnionFind(unionFind);
            unionFindCopy.union(requests[i][0], requests[i][1]);
            boolean ifUnion = true;
            for (int j = 0; j < restrictions.length; j++) {
                if (unionFindCopy.findParent(restrictions[j][0]) == unionFindCopy.findParent(restrictions[j][1])) {
                    ifUnion = false;
                    break;
                }
            }
            System.out.println(unionFindCopy);
            if (ifUnion) {
                res[i] = true;
                unionFind = unionFindCopy;
            }
        }
        return res;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public UnionFind(UnionFind unionFind) {
            this.parent = new int[unionFind.parent.length];
            for (int i = 0; i < parent.length; i++) {
                this.parent[i] = unionFind.parent[i];
            }
        }

        public void union(int x, int y) {
            this.parent[findParent(x)] = findParent(y);
        }

        public int findParent(int x) {
            if (this.parent[x] != x) {
                this.parent[x] = findParent(this.parent[x]);
            }
            return this.parent[x];
        }

        @Override
        public String toString() {
            return Arrays.toString(parent);
        }
    }
}
