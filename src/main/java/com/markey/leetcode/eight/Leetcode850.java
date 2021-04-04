package com.markey.leetcode.eight;

import java.util.TreeMap;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.eight
 * @ClassName: Leetcode850
 * @Author: markey
 * @Description:
 * @Date: 2021/3/8 22:56
 * @Version: 1.0
 */
public class Leetcode850 {
    // 太难了
    public int rectangleArea(int[][] rectangles) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int index = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];

        }
        SegmentNode segmentNode = new SegmentNode(0, 1_000_000_000, 0);
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            segmentNode.update(rectangle[0], rectangle[2], rectangle[3]);
        }
        return 0;
    }

    class SegmentNode {
        int start;
        int end;
        int height;
        SegmentNode left, right;

        public SegmentNode(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }

        public int getMid() {
            return start + (end - start) / 2;
        }

        public SegmentNode getLeft() {
            if (left == null) {
                left = new SegmentNode(start, getMid(), height);
            }
            return left;
        }

        public SegmentNode getRight() {
            if (right == null) {
                right = new SegmentNode(getMid() + 1, end, height);
            }
            return right;
        }

        public void update(int from, int to, int height) {
            if (from <= start && to >= end) {
                this.height = Math.max(this.height, height);
            } else {
                int mid = getMid();
                if (from <= mid) {
                    getLeft().update(from, mid, height);
                }
                if (to >= mid + 1) {
                    getRight().update(mid + 1, to, height);
                }
            }
        }

        public int getHeight(int i, int j) {
            if (start == i && end == j) {
                return height;
            }
            int res = Integer.MAX_VALUE;
            if (i <= getMid()) {
                res = Math.min(res, getHeight(i, getMid()));
            }
            if (j >= getMid() + 1) {
                res = Math.min(res, getHeight(getMid() + 1, j));
            }
            return res;
        }
    }
}
