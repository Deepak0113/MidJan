import java.util.ArrayList;
import java.util.Stack;

public class Question1 {
    static boolean validate(String string){
        char ch = string.charAt(0);
        if(ch == ')') return false;
        if(ch=='+' || ch=='-' || ch=='*' || ch=='/') return false;

        Stack<Character> stack = new Stack<>();

        stack.add(string.charAt(0));
        int i=1;

        while(!stack.empty() && i<string.length()){
            ch = string.charAt(i);

            if(ch>='a' && ch<='z'){
                if(Character.isAlphabetic(stack.peek())) return false;

                if(stack.peek() == '('){
                    stack.push(ch);
                } else{
                    stack.pop();
                    stack.pop();
                    stack.push(ch);
                }
            } else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                if(!(stack.peek()>='a' && stack.peek()<='z')) return false;
                stack.push(ch);
            } else if(ch == ')'){
                if(!(stack.peek()>='a' && stack.peek()<='z')) return false;

                while(stack.peek() != '('){
                    stack.pop();
                }
                stack.pop();
            } else if(ch == '('){
                stack.push(ch);
            }

            i++;
        }

        if(!stack.empty()) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("(a+b)(a*b)"));
        System.out.println(validate("(ab)(ab+)"));
        System.out.println(validate("((a+b)"));
        System.out.println(validate("()()a+b"));
        System.out.println(validate("(a)(b)"));
        System.out.println(validate("((a+b+c)a+b)"));
        System.out.println(validate("((a++b)"));
        System.out.println(validate("()"));
        System.out.println(validate("(a+)"));
        System.out.println(validate("+a"));
    }
}
