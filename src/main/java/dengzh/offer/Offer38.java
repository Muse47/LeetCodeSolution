package dengzh.offer;

import java.util.*;

/**
 * @Description 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 限制：
 * 1 <= s 的长度 <= 8
 * @Author dengziheng
 * @Date 2021/8/24 23:15
 */
public class Offer38 {
    public static void main(String[] args) {

        String[] abcs = permutation("abc");
        System.out.println(Arrays.toString(abcs));
    }
    public static String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        char[] arr = s.toCharArray();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, "", visited, list);
        return list.toArray(new String[0]);
    }

    public static void dfs(char[] arr, String s, boolean[] visited, Set<String> list) {
        if (s.length() == arr.length) {
            list.add(s);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            /**
             * 跳过元素，思路类似{@link dengzh.hot100.Solution39#dfs(int[], int, int, int, Deque, List)}
             */
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(arr, s + arr[i], visited, list);
            visited[i] = false;
        }
    }


}
