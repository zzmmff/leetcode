import java.util.HashMap;
import java.util.Map;

public class LC560 {
    /**
     * 子数组问题 暴力解法
     */
    public int subarraySum(int[] nums, int k) {
        int asn = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j >= 0; j--) {
                temp += nums[j];
                if (temp == k)
                    asn++;
            }
        }
        return asn;
    }
    
    /**
     * 优化解法，使用前缀和数组 
     */
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int ans = 0;
        
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i]; 
            Integer orDefault = map.getOrDefault(preSum, 0);
            orDefault++;
            map.put(preSum, orDefault);
            Integer integer = map.get(preSum - k);
            if (integer != null)
                ans += integer;
            if (nums[i] == k)
                ans++;
        }
        return ans;
    }
}