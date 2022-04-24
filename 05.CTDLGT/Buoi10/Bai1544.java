import java.util.Stack;

public class Bai1544 {
    public String makeGood(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                String lastChar = stack.peek();
                if (!c.equals(lastChar) && c.equalsIgnoreCase(lastChar)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}