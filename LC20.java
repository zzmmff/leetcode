import java.util.ArrayDeque;
import java.util.Deque;

public class LC20 {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        if ((charArray.length & 1) == 1)
            return false;

        Deque<Character> stack = new ArrayDeque<>();
      for (char c : charArray) {
          if (stack.isEmpty()) {
              stack.addFirst(c);
              continue;
          }
          Character peekFirst = stack.peekFirst();
          if (check(peekFirst, c)) {
              stack.removeFirst();
          } else {
            stack.addFirst(c);
        }
      }
        return stack.isEmpty();
    }
    
    private boolean check(char c1, char c2) {
        return (c1 == '{' && c2 == '}') ||
         (c1 == '[' && c2 == ']') ||
                (c1 == '(' && c2 == ')');
    }
}
