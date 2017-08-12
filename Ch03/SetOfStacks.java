package Ch03;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks{
    ArrayList<Stack> list;
    ArrayList<Integer> size;
    private int threshold = 10;

    /**
     * Class Constructor. If no threshold value is
     * given, then the default threshold value is 10
     * objects per stack.
     */
    public SetOfStacks(int threshold) {
        list = new ArrayList<>();
        list.add(new Stack<>());
        size = new ArrayList<>();
        size.add(0);
        this.threshold = threshold;
    }

    public Object push(Object item) {
        int location = size.size() -1;
        list.get(location).add(item);
        size.set(location, size.get(location) + 1);
        if (size.get(location) == threshold) {
            list.add(new Stack<>());
            size.add(0);
        }
        return item;
    }

    public Object pop() {
        int location = size.size() -1;
        if (size.get(location) == 0){
            list.remove(location); // If no more stack, it will throw EmptyStackException.
            size.remove(location);
            return this.pop();
        }
        size.set(location, size.get(location) - 1);
        return list.get(location).pop();

    }

    public Object popAt(int index){
        Stack temp = list.get(index);
        Object item = temp.pop();
        size.set(index, size.get(index) - 1);
        if (temp.isEmpty() && size.size() -1 != index){ // if this stack is not the last stack,
            list.remove(index);
            size.remove(index);
        }
        return item;
    }

    public boolean isEmpty(){
        return size.get(0) == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World");
        SetOfStacks obj = new SetOfStacks(10);
        for (int i = 1; i < 35; i++){
            obj.push(i);
        }

        System.out.println("List size:" + obj.list.size());

        int counter = 6;
        while (counter > 0){
            System.out.println(obj.popAt(0));
            System.out.println(obj.popAt(2));
            counter--;
            System.out.println("List size:" + obj.list.size());
            System.out.println();
        }


        counter = 15;
        System.out.println("Pop all");
        while (counter > 0){
            System.out.println(obj.pop());
            System.out.println("List size:" + obj.list.size());
            System.out.println();
            counter--;
        }
    }

}
