import java.util.Stack;

public class Bai844 {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = stackFromString(s);
        Stack<Character> stack2 = stackFromString(t);

        return stack1.equals(stack2);
    }

    public static Stack<Character> stackFromString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f")); // true
    }
}