package com.markey.leetcode.zero;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.zero
 * @ClassName: Leetcode71
 * @Author: markey
 * @Description:
 * @Date: 2021/10/13 22:01
 * @Version: 1.0
 */
public class Leetcode71 {
    public String simplifyPath(String path) {
        String[] elements = path.split("/");
        List<String> pathList = new ArrayList<>();
        for (String element : elements) {
            if (element.equals("") || element.equals(".")) {
                continue;
            }
            if (element.equals("..")) {
                if (pathList.size() > 0){
                    pathList.remove(pathList.size() - 1);
                }
                continue;
            }
            pathList.add(element);
        }
        return "/" + String.join("/", pathList);
    }
}
