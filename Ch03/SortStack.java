package Ch03;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

/**
 * CTCI Question 3.5 Sort Stack.
 * Write a program to sort a stack such that the smallest items are on the top.
 */
public class SortStack {

    /**
     * My implementation: it is faster than standard solution.
     * @param stack
     * @return
     */
    public static void sort_2(Stack<Integer> stack){
        Stack<Integer> helper = new Stack<>();

        while(!stack.isEmpty()){
            addElement(stack, helper, stack.pop());
        }

        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }
    }

    private static void addElement (Stack<Integer> s_origin, Stack<Integer> s_new, Integer e){
        if (s_new.isEmpty() || e >= s_new.peek()){
            s_new.add(e);
            return;
        }

        s_origin.add(s_new.pop()); // Move smaller element from new to origin.
        addElement(s_origin, s_new, e);
        s_new.add(s_origin.pop()); // Move smaller element back to new.
    }


    public static void BookSolution (Stack<Integer> ori){
        Stack<Integer> helper = new Stack<>();
        while(!ori.isEmpty()){
            int temp = ori.pop();

            while(!helper.isEmpty() && helper.peek() > temp){
                ori.push(helper.pop());
            }
            helper.push(temp);
        }
        while( !helper.isEmpty()){
            ori.push(helper.pop());
        }
    }

    public static void main(String[] args) {
        Random random = ThreadLocalRandom.current();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stdStack = new Stack<>();
        long start;

        // Add values to stacks
        for (int i = 0; i < 10000; i++){
            int temp = random.nextInt(10000);
            System.out.print(temp + " - ");
            stack.add(temp);
            stdStack.add(temp);
        }
        System.out.println("stdStack " + stdStack.isEmpty());

        // My implementation
        System.out.println("My implementation: ");
        start = System.currentTimeMillis();

        sort_2(stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " - ");
        }
        System.out.println();

        System.out.println("Time usage: " + (System.currentTimeMillis() - start));

        // Standard Solution.
        System.out.println();
        System.out.println("Book solution:");

        start = System.currentTimeMillis();
        BookSolution(stdStack);
        while(!stdStack.isEmpty()){
            System.out.print(stdStack.pop() + " - ");
        }
        System.out.println();

        System.out.println("Time usage: " + (System.currentTimeMillis() - start));


    }
}
