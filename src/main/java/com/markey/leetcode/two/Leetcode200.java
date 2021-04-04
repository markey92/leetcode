package com.markey.leetcode.two;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.two
 * @ClassName: Leetcode200
 * @Author: markey
 * @Description:
 * @Date: 2020/12/20 20:12
 * @Version: 1.0
 */
public class Leetcode200 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col= grid[0].length;
        UnionFind unionFind = new UnionFind(row * col);
        int space = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    // 因为并查集中空白字符的parent也是自己，算是单独的一块,所以最后结果要减掉这个
                    space++;
                } else {
                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        unionFind.union(getIndex(i, j, col), getIndex(i + 1, j, col));
                    }
                    if (j + 1 < col && grid[i][j + 1] == '1') {
                        unionFind.union(getIndex(i, j, col), getIndex(i, j + 1, col));
                    }
                }
            }
        }
        return unionFind.count - space;
    }

    private int getIndex(int i, int j, int col) {
        return i * col + j;
    }

    // 并查集对象，实现查找、合并两个方法
    class UnionFind {
        int count;
        int[] parent;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty) {
                return;
            }
            parent[rootx] = rooty;
            count--;
        }
    }
}
