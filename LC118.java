import java.util.ArrayList;
import java.util.List;

public class LC118 {

       public List<List<Integer>> generate(int numRows) {
           List<List<Integer>> ans = new ArrayList<>();
        
           for (int i = 0; i < numRows; i++) {
               ArrayList<Integer> row = new ArrayList<>();
               for (int j = 0; j <= i; j++) {
                   if (j == 0 || j == i) {
                       row.add(1);
                       continue;
                   }
                   int top = i - 1;
                   if (top < 0)
                       break;
                   row.add(ans.get(top).get(j - 1) + ans.get(top).get(j));
               }
               ans.add(row);
           }
           return ans;
   }

}
