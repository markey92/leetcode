package string;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String10
 * @Author: markey
 * @Description:
 * @Date: 2020/5/1 18:25
 * @Version: 1.0
 */
public class String10 {
    public boolean isMatch(String s, String p) {
        int sIndex = s.length() - 1;
        int pIndex = p.length() - 1;
        for (; pIndex >= 0; pIndex--) {
            if (sIndex < 0) {
                break;
            }
            if (p.charAt(pIndex) == '.') {
                sIndex--;
                continue;
            }
            if (p.charAt(pIndex) == '*') {
                pIndex--;
                char x = p.charAt(pIndex);
                if (x == '.') {
                    return true;
                }
                while (sIndex >= 0) {
                    if (s.charAt(sIndex) == x) {
                        sIndex--;
                    } else {
                        break;
                    }
                }
                continue;
            }
            if (p.charAt(pIndex) == s.charAt(sIndex)) {
                sIndex--;
            } else {
                return false;
            }
        }
        // s没匹配完
        if (sIndex >= 0) {
            return false;
        }
        // 检查p还有没有
        System.out.println(pIndex);
        while (pIndex >= 0 && p.charAt(pIndex) == '*') {
            pIndex -= 2;
        }

        return pIndex < 0;
    }
}
