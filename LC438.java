import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC438 {
     public List<Integer> findAnagrams(String s, String p) {
         //滑动窗口 判断两个字符串是否是组合的方法很重要
        
         int[] nums = new int[26];
         int differ = 0; //不同的字母个数 
         if (p.length() > s.length())
             return new ArrayList<>();
         for (int i = 0; i < p.length(); i++) 
         {// 一定不能s-- p++ 如果非要这样，需要修改后面的迭代逻辑
             nums[p.charAt(i) - 'a']--;
             nums[s.charAt(i) - 'a']++;
         }
         for (int i = 0; i < nums.length; i++) 
         {
             if (nums[i] != 0)
                 differ++;
         }
         ArrayList<Integer> ans = new ArrayList<>();
         if (differ == 0)
             ans.add(0);
         for (int i = 0; i < s.length() - p.length(); i++) {
             //此时放入i + p.length  拿去 i
             if (nums[s.charAt(i) - 'a'] == 1) { // s(i) 的字母个数变得相同
                 differ--;
             } else if (nums[s.charAt(i) - 'a'] == 0) { //s(i)的字母个数变得不同
                 differ++;
             } //拿走的字符符合
            
             nums[s.charAt(i) - 'a']--;
            
             if (nums[s.charAt(i+p.length()) - 'a'] == -1) { //s(i+1) 相同
                 differ--;
             }
             if (nums[s.charAt(i+p.length()) - 'a'] == 0) { //s(i+1)不 相同
                 differ++;
             }
             nums[s.charAt(i + p.length()) - 'a']++;
             if (differ == 0)
                 ans.add(i + 1);
        }
        return ans;
    }
}