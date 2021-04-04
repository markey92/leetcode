package high_level.segment_tree;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: high_level.segment_tree
 * @ClassName: Leetcode699_1
 * @Author: markey
 * @Description:
 * @Date: 2020/11/8 21:06
 * @Version: 1.0
 */
public class Leetcode699_1 {
    public List<Integer> fallingSquares(int[][] positions) {
        //Coordinate Compression
        /**
         * 坐标压缩
         *
         * 数轴上最多有 2 * len(positions) 个临界点，即每个方块的左右边缘，使用坐标压缩将这些临界点映射到相应的整数位置，具体实现如下图代码所示。
         *
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/falling-squares/solution/diao-luo-de-fang-kuai-by-leetcode/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        Set<Integer> coords = new HashSet();
        for (int[] pos: positions) {
            coords.add(pos[0]);
            coords.add(pos[0] + pos[1] - 1);
        }
        List<Integer> sortedCoords = new ArrayList(coords);
        Collections.sort(sortedCoords);

        Map<Integer, Integer> index = new HashMap();
        int t = 0;
        for (int coord: sortedCoords) index.put(coord, t++);


        SegmentTree tree = new SegmentTree(sortedCoords.size());
        int best = 0;
        List<Integer> ans = new ArrayList();

        for (int[] pos: positions) {
            int L = index.get(pos[0]);
            int R = index.get(pos[0] + pos[1] - 1);
            int h = tree.query(L, R) + pos[1];
            tree.update(L, R, h);
            best = Math.max(best, h);
            ans.add(best);
        }
        return ans;
    }

    // 数组模拟树
    class SegmentTree {
        int N, H;
        int[] tree, lazy;

        SegmentTree(int N) {
            this.N = N;
            H = 1;
            while ((1 << H) < N) H++;
            tree = new int[2 * N];
            lazy = new int[N];
        }

        private void apply(int x, int val) {
            tree[x] = Math.max(tree[x], val);
            if (x < N) lazy[x] = Math.max(lazy[x], val);
        }

        private void pull(int x) {
            while (x > 1) {
                x >>= 1;
                tree[x] = Math.max(tree[x * 2], tree[x * 2 + 1]);
                tree[x] = Math.max(tree[x], lazy[x]);
            }
        }

        private void push(int x) {
            for (int h = H; h > 0; h--) {
                int y = x >> h;
                if (lazy[y] > 0) {
                    apply(y * 2, lazy[y]);
                    apply(y * 2 + 1, lazy[y]);
                    lazy[y] = 0;
                }
            }
        }

        public void update(int L, int R, int h) {
            L += N; R += N;
            int L0 = L, R0 = R, ans = 0;
            while (L <= R) {
                if ((L & 1) == 1) apply(L++, h);
                if ((R & 1) == 0) apply(R--, h);
                L >>= 1; R >>= 1;
            }
            pull(L0); pull(R0);
        }

        public int query(int L, int R) {
            L += N; R += N;
            int ans = 0;
            push(L); push(R);
            while (L <= R) {
                if ((L & 1) == 1) ans = Math.max(ans, tree[L++]);
                if ((R & 1) == 0) ans = Math.max(ans, tree[R--]);
                L >>= 1; R >>= 1;
            }
            return ans;
        }
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/falling-squares/solution/diao-luo-de-fang-kuai-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
