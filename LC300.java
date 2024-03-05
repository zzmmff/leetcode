public class LC300 {
    /**
     * 最长递增子序列问题
     */
    public int lengthOfLIS(int[] nums) { 
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1); //此处有优化空间
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        LC300 lc300 = new LC300();
        int lengthOfLIS = lc300.lengthOfLIS(new int[] { 0,1,0,3,2,3 });
        System.out.println(lengthOfLIS);
    }
}
