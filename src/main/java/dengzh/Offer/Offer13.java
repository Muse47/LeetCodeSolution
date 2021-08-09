package dengzh.Offer;

/**
 * @Description 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * @Author dengziheng
 * @Date 2021/8/9 22:41
 */
public class Offer13 {

    public static void main(String[] args) {
        int movingCount = movingCount(1, 2, 1);
        System.out.println(movingCount);
    }

    public static int movingCount(int m, int n, int k){
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private static int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || i / 10 + i % 10 + j / 10 + j % 10 > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited)
                + dfs(i, j + 1, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited)
                + 1;
    }


    /*
    public static int movingCount(int m, int n, int k) {
        int result = 0;
        for(int i =0;i<=m;i++){
            for(int j = 0;j<=n;j++){
                if(validate(i,j,k)){
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean validate(int m, int n, int k){
        String mStr = String.valueOf(m);
        String nStr = String.valueOf(n);
        char[] mChar = mStr.toCharArray();
        char[] nChar = nStr.toCharArray();
        int mSum = 0;
        int nSum = 0;
        for(int i = 0;i<mChar.length;i++){
            mSum+=mChar[i]-48;
        }
        for(int j = 0;j<nChar.length;j++){
            nSum+=nChar[j]-48;
        }
        return k>=mSum+nSum;
    }
    */
}
