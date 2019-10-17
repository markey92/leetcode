package string;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String1108
 * @Author: markey
 * @Description:
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/defanging-an-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/18 0:37
 * @Version: 1.0
 */
public class String1108 {

    /**
     * 执行用时 :3 ms, 在所有 java 提交中击败了56.60%的用户
     * 内存消耗 :34.4 MB, 在所有 java 提交中击败了100.00%的用户
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
