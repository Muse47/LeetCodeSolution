package dengzh.hot100;

import java.util.*;

/**
 * @Description 39. 组合总和
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author dengziheng
 * @Date 2021/8/20 22:02
 */
public class Solution39 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(Arrays.toString(lists.toArray()));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        dfs(candidates, 0, len, target, path, res);

        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    public static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        //挑选每一层级开始元素
        //注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            path.add(candidates[i]);

            //进入下一层级
            dfs(candidates, i, len, target - candidates[i], path, res);

            //如果没有return，则回溯->去掉当前层级的选择，回到上一层级选择下一个begin开始
            path.removeLast();
        }
    }

    //非剪枝版本
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        int len = candidates.length;
//        Deque<Integer> path = new ArrayDeque<>();
//        List<List<Integer>> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//        dfs(candidates, 0, len, target, path, res);
//
//        return res;
//    }
//
//    public static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
//        if (target < 0) {
//            return;
//        }
//        if (target == 0) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = begin; i < len; i++) {
//            path.add(candidates[i]);
//
//            dfs(candidates, i, len, target - candidates[i], path, res);
//
//            path.removeLast();
//        }
//    }
}
