import java.util.Stack;

public class Bai394 {
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int counter = 0;
        String content = "";
        String multiplyContent = "";

        for (char c : s.toCharArray()) {
            System.out.println("c = " + c);
            stack.push(c);
            System.out.println("stack = " + stack);
            if (stack.peek() == '[') {
                counter++;
            } else if (stack.peek() == ']') {
                counter--;
                stack.pop(); // ']'
                System.out.println("stack = " + stack);
                content = multiplyContent;
                while (stack.peek() != '[') {
                    content = stack.pop() + content;
                }
                System.out.println("content = " + content);
                stack.pop(); // '[';
                System.out.println("stack = " + stack);
                String digits = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    digits = stack.pop() + digits;
                }
                int multiply = Integer.parseInt(digits);
                System.out.println("multiply = " + multiply);
                multiplyContent = "";
                for (int i = 0; i < (int) multiply; i++) {
                    multiplyContent += content;
                }
                System.out.println("multiplyContent = " + multiplyContent);
                if (counter == 0) {
                    sb.append(multiplyContent);
                    multiplyContent = "";
                }
            } else if (counter == 0 && !stack.isEmpty() && !Character.isDigit(c)) {
                sb.append(c);
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // System.out.println(decodeString("3[a]2[bc]"));
        // System.out.println(decodeString("3[a2[c]]"));
        // System.out.println(decodeString("2[abc]3[cd]ef"));
        // System.out.println(decodeString("a2[2[2[c]]]"));
        // System.out.println(decodeString("10[e]"));
        System.out.println(decodeString("2[2[a]3[b]]"));
        // System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
