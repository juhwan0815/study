package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 올바른괄호 {

    public static void main(String[] args) {
        solution("()()");
        solution("(())()");
        solution(")()(");
        solution("(()(");
    }

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;

        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push('(');
            }
        }

        if(!stack.isEmpty()){
            result = false;
        }

        return result;
    }
}
