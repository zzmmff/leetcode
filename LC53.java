public class LC53 {
     public int maxSubArray(int[] nums) {
         //前缀和 超时
         int[] preSum = new int[nums.length];
         int sum = 0;
         for (int i = 0; i < nums.length; i++) {
             sum += nums[i];
             preSum[i] = sum;
        }
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                ans = Math.max(ans, preSum[i]);
            } else {
                ans = Math.max(ans, preSum[i] - preSum[j]);
            }
            }
        }
        return ans;
    }

    public int maxSubArray2(int[] nums) {
        //dp
        int[] dp = new int[nums.length];
        int ans = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
