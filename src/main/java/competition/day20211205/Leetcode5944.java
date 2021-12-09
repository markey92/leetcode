package competition.day20211205;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211205
 * @ClassName: Leetcode5944
 * @Author: markey
 * @Description:
 * @Date: 2021/12/5 10:51
 * @Version: 1.0
 */
public class Leetcode5944 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder(getPath(root, startValue, new StringBuilder()));
        StringBuilder destPath = new StringBuilder(getPath(root, destValue, new StringBuilder()));
        System.out.println(startPath.toString() + " : " + destPath.toString());
        while (startPath.length() > 0 && destPath.length() > 0 && startPath.charAt(0) == destPath.charAt(0)) {
            startPath.deleteCharAt(0);
            destPath.deleteCharAt(0);
        }
        System.out.println(startPath.toString() + " : " + destPath.toString());
        StringBuilder res = new StringBuilder();
        if (startPath.length() == 0) {
            res.append(destPath);
        } else if (destPath.length() == 0) {
            for (int i = 0; i < startPath.length(); i++) {
                res.append("U");
            }
        } else {
            for (int i = 0; i < startPath.length(); i++) {
                res.append("U");
            }
            res.append(destPath);
        }
        return res.toString();
    }

    public String getPath(TreeNode root, int value, StringBuilder prePath) {
        if (root.val == value) {
            return prePath.toString();
        }
        if (root.left != null) {
            prePath.append("L");
            String leftPath = getPath(root.left, value, prePath);
            if (leftPath != null) {
                return leftPath;
            }
            prePath.deleteCharAt(prePath.length() - 1);
        }
        if (root.right != null) {
            prePath.append("R");
            String rightPath = getPath(root.right, value, prePath);
            if (rightPath != null) {
                return rightPath;
            }
            prePath.deleteCharAt(prePath.length() - 1);
        }
        return null;
    }
}
