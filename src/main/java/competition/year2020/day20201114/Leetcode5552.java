//package competition.day20201114;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * @ProjectName: leetcode
// * @Package: competition.day20201114
// * @ClassName: Leetcode5552
// * @Author: markey
// * @Description:
// * @Date: 2020/11/14 23:10
// * @Version: 1.0
// */
//public class Leetcode5552 {
//    public int minimumJumps(int[] forbidden, int a, int b, int x) {
//        if (x == 0) {
//            return 0;
//        }
//        int[] local = new int[40000];
//        for (int i = 0; i < forbidden.length; i++) {
//            local[forbidden[i]] = Integer.MAX_VALUE;
//        }
//        Queue<Node> needRefresh = new LinkedList<>();
//        needRefresh.add(new Node(0, -1));
//        while (!needRefresh.isEmpty()) {
//            Node node = needRefresh.poll();
//            int index = node.local;
//            if (index + a < 40000 && (local[index + a] == 0 || node.local < node.parent) && local[index + a] != Integer.MAX_VALUE) {
//                local[index + a] = local[index] + 1;
//                needRefresh.add(new Node(index + a, index));
//                if (index + a == x) {
//                    return local[index + a];
//                }
//            }
//            if (node.parent < node.local && index - b >= 0 && local[index - b] == 0 && local[index - b] != Integer.MAX_VALUE) {
//                local[index - b] = local[index] + 1;
//                needRefresh.add(new Node(index - b, index));
//                if (index - b == x) {
//                    return local[index - b];
//                }
//            }
//        }
//        if (local[x] == 0) {
//            return -1;
//        }
//        return local[x];
//    }
//
//    class Node {
//        public Node(int local, int parent) {
//            this.local = local;
//            this.parent = parent;
//        }
//
//        int local;
//        int parent;
//    }
//}
