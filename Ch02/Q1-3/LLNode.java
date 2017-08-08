package Ch02;

import java.util.HashSet;


/**
 * LLNode. Contains datastructure of singly linked node.
 * In addition, the solution for CTCI question 2.1 to 2.3 is also included.
 * @author frostzyh
 */
public class LLNode {
    // Singly linked list.
    LLNode next = null;
    int num;

    public LLNode(int num) {this.num = num;}

    public LLNode(char c) {
        this.num = (int) c;
    }

    void addToEnd(char data){
        addToEnd((int) data);
    }

    void addToEnd(int data) {
        LLNode end = new LLNode(data);
        LLNode n = this;
        while (n.next != null) n = n.next;
        n.next = end;
    }

    LLNode delete(LLNode head, int d){
        LLNode n = head;
        if (n.num == d) return n.next;

        while(n.next != null){
            if (n.next.num == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        System.err.println("The variable was not found in the list.");
        return head;
    }

    /**
     * Convert integer array to a Singly linked list
     * character in ASCII .
     * @param array each element in array is a integer which is equavalent
     *              to the index of an ASCII character.
     * @return the head of the list.
     */
    static LLNode generateList(int[] array){
        if (array.length == 0) return null;
        LLNode head = new LLNode((char) array[0]);
        LLNode n = head;
        for (int i = 1; i < array.length; i++){
            n.next = new LLNode((char) array[i]);
            n = n.next;
        }
        return head;
    }

    @Override
    public String toString() {
        return Integer.toString(this.num);
    }

    public String toCharString() {return Character.toString((char) this.num);}

    public String printList() {
        StringBuilder sb = new StringBuilder();
        LLNode n = this;
        while(n != null){
            sb.append(n.num);
            sb.append(" => ");
            n = n.next;
        }
        sb.append("End");
        return sb.toString();
    }

    public String printCharList() {
        StringBuilder sb = new StringBuilder();
        LLNode n = this;
        while(n != null){
            sb.append((char) n.num);
            sb.append(" => ");
            n = n.next;
        }
        sb.append("End");
        return sb.toString();
    }

    /**
     * Return deep copy of this list
     */
    static LLNode deepCopy(LLNode t) {
        LLNode originNode = t;
        LLNode head = new LLNode(originNode.num);
        LLNode pointer = head;
        while(originNode.next != null){
            originNode = originNode.next;
            pointer.next = new LLNode(originNode.num);
            pointer = pointer.next;
        }
        return head;
    }

    /**
     * CTCI Question 2.1 Remove duplicates from the linked list.
     * @param head
     * @return
     */
    public static void RemoveDups(LLNode head){
        HashSet<Integer> hs = new HashSet<>();
        hs.add(head.num);
        LLNode currNode = head;
        while (currNode.next != null){
            if (hs.contains(currNode.next.num)){
                currNode.next = currNode.next.next;
            }
            else {
                currNode = currNode.next;
                hs.add(currNode.num);
            }
        }
    }

    /**
     * CTCI Q2.2 Return Kth(from last) element which counts from the last node.
     * @param head
     * @param k
     * @return
     * O(2n)
     */
    public static String KthToLast(LLNode head, int k){
        // find size
        int size = 0;
        LLNode curr = head;
        while (curr != null){ // O(n)
            size++;
            curr = curr.next;
        }

        if (k > size) return "No element can be found.";
        int index = size -k;

        curr = head;
        while(index > 0){ // O(n)
            curr = curr.next;
            index--;
        }

        return curr.toString();
    }


    // Time O(n)
    public static String KthToLastOp(LLNode head, int k){
        LLNode p1 = head; // Pointer 1
        LLNode p2 = head; // Pointer 2
        int counter = 1;
        while (counter < k){
            p2 = p2.next;
            counter ++;
            if (p2 == null) return "No element can be found.";
        }

        while (p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1.toString();
    }

    /**
     * CTCI Q2.3 Delete Middle Node. Given you a node which is not head nor end.
     * Remove this node and return nothing.
     * @param t
     */
    public static void deleteThisNode(LLNode t){
        // This solution is very stupid. Check deleteThisNodeOp
        LLNode curr = t;
        while(curr.next.next != null){
            curr.num = curr.next.num;
            curr = curr.next;
        }
        curr.num = curr.next.num;
        curr.next = null;
    }

    public static void deleteThisNodeOp(LLNode t){
        // This solution is very stupid. Check deleteThisNodeOp

        if (t == null || t.next == null) return;
        t.num = t.next.num;
        t.next = t.next.next;
    }

    public static void main(String[] args) {
        RandomNumGenerator rng = new RandomNumGenerator('a','k');
        LLNode head = LLNode.generateList(rng.getArray());

        System.out.println(head.printList());

        System.out.println("Delete g");
        head.delete(head,'g');
        System.out.println(head.printList());

        System.out.println("Add z to the end:");
        head.addToEnd('z');
        System.out.println(head.printList());

        System.out.println("Q2.1: Testing on RemoveDups:");
        int[] dupArray = {5,4,2,2,8,6,6,1,0,4,4};
        LLNode dupList = LLNode.generateList(dupArray);
        System.out.println(dupList.printList());
        RemoveDups(dupList);
        System.out.println(dupList.printList());
        System.out.println();

        System.out.println("Q2.2: Testing on KthToLast (4th)");
        System.out.println(head.printList());
        System.out.println(KthToLast(head,4));
        System.out.println(KthToLastOp(head,4));
        System.out.println();

        System.out.println("Q2.3: Delete Middle Node (delete 4th node)");
        System.out.println(head.printList());
        System.out.println("Stupid solution.");
        LLNode h1 = deepCopy(head);
        LLNode fourth = h1;
        for (int i = 1; i < 4; i++) fourth = fourth.next;
        deleteThisNode(fourth);
        System.out.println(h1.printList());
        // Optimized solution
        System.out.println("Optimized solution");
        h1 = deepCopy(head);
        fourth = h1;
        for (int i = 1; i < 4; i++) fourth = fourth.next;
        deleteThisNodeOp(fourth);
        System.out.println(h1.printList());
        System.out.println();


    }
}
