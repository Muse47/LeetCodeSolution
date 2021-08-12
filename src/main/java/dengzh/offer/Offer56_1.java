package dengzh.offer;

import java.util.Arrays;

/**
 * @Description 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @Author dengziheng
 * @Date 2021/8/13 00:23
 */
public class Offer56_1 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 6};
        int[] ints = singleNumbers(nums);
        System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
    }
    public static int[] singleNumbers(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }
        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}


/*
异或满足交换律，第一步异或，相同的数其实都抵消了，剩下两个不同的数。这两个数异或结果肯定有某一位为1，不然都是0的话就是相同数。
找到这个位，不同的两个数一个在此位为0，另一个为1。按此位将所有数分成两组，分开后各自异或，相同的两个数异或肯定为0（而且分开的时候，两个数必为一组）。
剩下的每组里就是我门要找的数。
 */