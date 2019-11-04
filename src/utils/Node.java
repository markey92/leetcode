package utils;

import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: utils
 * @ClassName: Node
 * @Author: markey
 * @Description:
 * @Date: 2019/11/4 22:43
 * @Version: 1.0
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
