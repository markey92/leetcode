package competition.year2021.day20211017;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211017
 * @ClassName: Leetcode5903
 * @Author: markey
 * @Description:
 * @Date: 2021/10/17 10:35
 * @Version: 1.0
 */
public class Leetcode5903 {
    class Bank {
        int n;
        long[] balance;
        public Bank(long[] balance) {
            this.n = balance.length;
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 < 1 || account1 > n || account2 < 1 || account2 > n) {
                return false;
            }
            if (balance[getBalance(account1)] >= money) {
                balance[getBalance(account1)] -= money;
                balance[getBalance(account2)] += money;
                return true;
            }
            return false;
        }

        public boolean deposit(int account, long money) {
            if (account < 1 || account > n) {
                return false;
            }
            balance[getBalance(account)] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account < 1 || account > n || balance[getBalance(account)] < money) {
                return false;
            }
            balance[getBalance(account)] -= money;
            return true;
        }

        private int getBalance(int account) {
            return account - 1;
        }
    }
}
