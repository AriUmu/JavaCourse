package Lesson10;

/**
 * Created by arina on 12.07.17.
 */
public class UseStack {

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        System.out.println(stack);

        stack.pop();
        stack.pop();

        stack.size();

        System.out.println(stack.tos());
        System.out.println(stack.size());
        System.out.println(stack);

    }

}
