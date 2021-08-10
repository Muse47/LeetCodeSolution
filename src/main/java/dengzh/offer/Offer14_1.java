package dengzh.offer;

/**
 * @Description 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 2 <= n <= 58
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author dengziheng
 * @Date 2021/8/10 22:22
 */
public class Offer14_1 {
    public static void main(String[] args) {
        int res = cuttingRope(10);
        System.out.println(res);
    }
    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        //长度为2的绳子最大值为1
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}


/*
思路一：动态规划
这题用动态规划是比较好理解的

我们想要求长度为n的绳子剪掉后的最大乘积，可以从前面比n小的绳子转移而来
用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，也就是dp[i]表示长度为i的绳子剪成m段后的最大乘积，初始化dp[2] = 1
我们先把绳子剪掉第一段（长度为j），如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪
剪了第一段后，剩下(i - j)长度可以剪也可以不剪。如果不剪的话长度乘积即为j * (i - j)；如果剪的话长度乘积即为j * dp[i - j]。取两者最大值max(j * (i - j), j * dp[i - j])
第一段长度j可以取的区间为[2,i)，对所有j不同的情况取最大值，因此最终dp[i]的转移方程为
dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
最后返回dp[n]即可
 */
