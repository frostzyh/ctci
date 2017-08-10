package Ch02;

import java.util.HashSet;
import java.util.Stack;


/**
 * LLNode. Contains datastructure of singly linked node.
 * In addition, the solution for CTCI question 2.1 to 2.3 is also included.
 * August 8, 2017 : 2.1 - 2.3
 * August 9, 2017 : 2.4 - 2.6
 * August 10, 2017 : 2.7 - 2.8
 * @author frostzyh
 */
public class LLNode {
    // Singly linked list.
    LLNode next = null;
    int num;

    public LLNode(){}

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
     * Return the length of the Linked List from the
     * node to the end.
     * TODO: This is not finished.
     * Ideas: 1. The length should only be calculated once.
     * 2. The class should store the length.
     * 3. When the structure is changes, update the value of length.
     * @param n
     * @return
     */
    int length(){
        LLNode n = this;
        int counter = 0;
        while(n != null){
            counter++;
            n = n.next;
        }
        return counter;
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

    /**
     * CTCI Q2.4 Partition
     * Rearrange the list so that all elements smaller than k
     * would be placed ahead of elements have same or larger value.
     * @param node
     * @param k
     * @return
     */
    public static LLNode partition(LLNode node, int k ){
        LLNode head = node;
        LLNode tail = node;

        while(node != null){
            LLNode next = node.next;
            if (node.num < k){
                node.next = head;
                head = node;
            }
            else{
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

    /**
     * CTCI Q2.5 Sum Lists
     * Input (7 -> 1 -> 6) + (5 -> 9 -> 2), that is 617+295
     * Expected Output 2 -> 1 -> 9  that is 912.
     * @param l1
     * @param l2
     * @return
     */
    public static LLNode SumListsReverse(LLNode l1, LLNode l2){
        int num1 = 0;
        int num2 = 0;
        int carry = 1;
        while (l1 != null){
            num1 += carry * l1.num;
            l1 = l1.next;
            carry *= 10;
        }
        carry = 1;
        while (l2 != null){
            num2 += carry * l2.num;
            l2 = l2.next;
            carry *= 10;
        }

        int sum = num1 + num2;
        LLNode ans = new LLNode();
        LLNode curr = ans;
        while(sum > 0){
            curr.next = new LLNode(sum % 10);
            curr = curr.next;
            sum = sum/ 10;
        }
        return ans.next;
    }


    public static LLNode SumListsReverse2 (LLNode l1, LLNode l2){
        LLNode ans = new LLNode();
        LLNode curr = ans;

        boolean carry = false;
        while(l1 != null || l2 != null || carry){
            int sum = carry ? 1 : 0;
            if (l1 != null) {
                sum += l1.num;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.num;
                l2 = l2.next;
            }
            curr.next = new LLNode(sum % 10);
            curr = curr.next;
            carry = sum >= 10 ? true : false;
        }
        return ans.next;
    }

    /**
     * Q 2.5 Extension. Calculate sum in forward order.
     * @param l1
     * @param l2
     * @return
     */
    public static LLNode SumLists(LLNode l1, LLNode l2){
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        int diff = l2.length() - l1.length();
        if (diff < 0) SumLists(l2, l1); // smaller one goes first

        LLNode head = new LLNode(0);
        head.num = SumListsHelper(head,l1,l2,diff) == 1 ? 1 : 0;
        return head.num == 0? head.next : head;
    }

    private static int SumListsHelper(LLNode prev, LLNode l1, LLNode l2, int diff){
        if (l1 == null) return 0;
        int sum;
        prev.next = new LLNode(0);

        if (diff > 0) sum = l2.num + SumListsHelper(prev.next, l1, l2.next, diff-1);

        else sum = l1.num + l2.num + SumListsHelper(prev.next, l1.next, l2.next, 0);

        prev.next.num = sum % 10;
        return sum >= 10 ? 1 : 0;
    }

    /**
     * 2.6 Palindrone
     * @param n
     * @return
     */
    public static boolean isPalindrome(LLNode n){
        if (n.next  == null) return true;
        LLNode slowRunner = n;
        LLNode fastRunner = n.next;

        Stack<Integer> stack = new Stack<>();
        stack.push(n.num);

        while(fastRunner.next != null && fastRunner.next.next != null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            stack.push(slowRunner.num);
        }
        if (fastRunner.next != null) slowRunner = slowRunner.next; // length of list is Odd.(skip middle element).
        while(!stack.isEmpty()){
            slowRunner = slowRunner.next;
            if (stack.pop() != slowRunner.num) return false;
        }
        return true;
    }

    public static boolean isPalindrome2(LLNode n){
        if (n.next  == null) return true;
        LLNode slowRunner = n;
        LLNode fastRunner = n.next;

        Stack<Integer> stack = new Stack<>();
        stack.push(n.num);

        while(fastRunner != null && fastRunner.next != null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            stack.push(slowRunner.num);
        }
        if (fastRunner == null) stack.pop(); // List has odd elements, pop middle one.

        while(!stack.isEmpty()){
            slowRunner = slowRunner.next;
            if (stack.pop() != slowRunner.num) return false;
        }
        return true;
    }

    /**
     * Q 2.7 Intersection. Given two singly linked list, find the intersection
     * which is the same object appears at both linked list.
     * @param l1
     * @param l2
     * @return
     */
    public static LLNode Intersection(LLNode l1, LLNode l2){
        // To improve efficient, we can compare the tail node of two lists, if their tail are not
        // the same node, return null.
        int len1 = l1.length();
        int len2 = l2.length();

        int diff = len2 - len1;
        if (diff < 0){ // switch l1 and l2 so l1 is always smaller or equal to l2 in size.
            LLNode temp = l1;
            l1 = l2;
            l2 = temp;
            diff = - diff;
        }

        System.out.println("This is l1 :" + l1.printList());
        System.out.println("This is l2 :" + l2.printList());

        while(diff > 0 ){
            l2 = l2.next;
            diff --;
        }
        while(l2 != null){
            if (l1 == l2) return l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

    /**
     * Q 2.8 Loop Detection
     * Within the condition of a linked list with a loop, if slow goes s steps,
     * then fast goes 2*s steps. Assume the nodes before the loop is u, then,
     * when slow = |u| (loop starting point), fast = |2u|. fast - slow = u.
     * Distance between slow and fast  = loop_size - mod(u,loop_size) = k.
     * From this point, both slow and fast move forward, then they will meet each other in
     * k steps since for each move, the distance between slow and fast reduces by 1.
     * Since slow moves from the beginning of the loop to k, then the distance from collision point
     * to the beginning is loop_size - k = loop_size - (loop_size - mod(u,loop_size)) = mod(u,loop_size).
     * Since u = u/loop_size + mod(u,loop_size), so after u moves from the collision point, ==>
     * - mod(u,loop_size) + u = u/loop_size => reaches starting point.
     * @param ll
     * @return
     */
    public static LLNode LoopDetection(LLNode ll){
        LLNode slow = ll;
        LLNode fast = ll;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        slow = ll;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        /*
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

        System.out.println("Q2.4 Partition:");
        int[] arr23 = {3, 5, 8, 5, 10, 2, 1};
        LLNode l23 = LLNode.generateList(arr23);
        System.out.println(l23.printList() + "  Partition = 5:");
        System.out.println(partition(l23,5).printList());

        System.out.println("Q2.5 Sum Lists:");
        int[] arr241 = {7,1,6};
        int[] arr242 = {5,9,7};
        LLNode l241 = LLNode.generateList(arr241);
        LLNode l242 = LLNode.generateList(arr242);
        System.out.println("617 + 795 = 1412. The reversed output should be 2->1->4->1.");
        System.out.println(SumListsReverse(l241,l242).printList());
        System.out.println(SumListsReverse2(l241,l242).printList());


        int[] arr243 = {2,7,9,4,5,0};
        LLNode l243 = LLNode.generateList(arr243);
        System.out.println("716 + 279450 = 280166. The output should be 2-8-0-1-6-6.");
        System.out.println(SumLists(l241,l243).printList());
        System.out.println();


        System.out.println("Q2.6 Palindrome");
        int[] arr25a = {1,7,6,5,3,5,6,7,1};
        int[] arr25b = {1,7,6,5,5,6,7,1};
        int[] arr25c = {1,7,6,5,3,5,6,2,1};
        LLNode l25a = LLNode.generateList(arr25a);
        LLNode l25b = LLNode.generateList(arr25b);
        LLNode l25c = LLNode.generateList(arr25c);
        System.out.println(l25a.printList());
        System.out.println(isPalindrome(l25a));
        System.out.println(isPalindrome2(l25a));
        System.out.println(l25b.printList());
        System.out.println(isPalindrome(l25b));
        System.out.println(isPalindrome2(l25b));
        System.out.println(l25c.printList());
        System.out.println(isPalindrome(l25c));
        System.out.println(isPalindrome2(l25c));
        System.out.println();
        */

        System.out.println("Q2.7 Intersection");
        // Create two linked list, l27a and l27b, which intersects.
        int[] arr271 = {6,5,2,1,7};
        int[] arr272 = {4,7,2};
        int[] arr273 = {8,9,2,5,1,7};
        LLNode list_inter = LLNode.generateList(arr273);
        LLNode l27a = LLNode.generateList(arr271);
        LLNode l27b = LLNode.generateList(arr272);
        LLNode l27temp = l27a;
        while(l27temp.next != null){
            l27temp = l27temp.next;
        }
        l27temp.next = list_inter;
        l27temp = l27b;
        while(l27temp.next != null){
            l27temp = l27temp.next;
        }
        l27temp.next = list_inter;
        // Call Intersection method
        System.out.println(Intersection(l27a,l27b).printList());


        System.out.println("Q2.8 Loop Detection: ");
        int[] arr28 = {9,5,2,1,3,4,6,7,8};
        LLNode li28 = LLNode.generateList(arr28);

        LLNode temp281 = li28;
        for (int i = 0; i < 3; i++) temp281 = temp281.next;
        LLNode temp282 = temp281;
        while(temp282.next != null) temp282 = temp282.next;
        temp282.next = temp281; // loop starts at 1
        temp281 = li28;
        for (int i = 0; i < 16; i++){
            System.out.print(temp281.toString() + " => ");
            temp281 = temp281.next;
        }
        System.out.println();

        LLNode q28ans = LoopDetection(li28);
        System.out.println(q28ans.toString());
    }
}