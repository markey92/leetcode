package com.markey.leetcode.one;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode1034
 * @Author: markey
 * @Description:
 * @Date: 2021/12/7 7:58
 * @Version: 1.0
 */
public class Leetcode1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Set<Node> connected = new HashSet<>();
        Set<Node> boundary = new HashSet<>();
        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(row, col));
        while (!deque.isEmpty()) {

            Node node = deque.poll();
            if (connected.contains(node)) {
                continue;
            }
            connected.add(node);
            for (int i = 0; i < directions.length; i++) {
                Node nextNode = new Node(node.row + directions[i][0], node.col + directions[i][1]);
                System.out.println(nextNode);
                if (nextNode.row >=0 && nextNode.row < n && nextNode.col >= 0 && nextNode.col < m) {
                    System.out.println(grid[nextNode.row][nextNode.col] == grid[row][col]);
                    if (grid[nextNode.row][nextNode.col] == grid[row][col]) {
                        deque.add(nextNode);
                    }
                }
            }
            boolean isBoundary = false;
            if (node.row == 0 || node.row == n - 1 || node.col == 0 || node.col == m - 1) {
                // 边界
                isBoundary = true;
            }
            if (!isBoundary) {
                for (int i = 0; i < directions.length; i++) {
                    Node nextNode = new Node(node.row + directions[i][0], node.col + directions[i][1]);
                    if (nextNode.row >=0 && nextNode.row < n && nextNode.col >= 0 && nextNode.col < m && grid[nextNode.row][nextNode.col] != grid[row][col]) {
                        isBoundary = true;
                        break;
                    }
                }
            }
            if (isBoundary) {
                // 边界染色
                boundary.add(node);
            }
        }
        for (Node node : boundary) {
            grid[node.row][node.col] = color;
        }
        return grid;
    }

    class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return row == node.row &&
                    col == node.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
