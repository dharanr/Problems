// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    
    private static int isPalinDrome(Node head){
        Node curr = head;
        Node mid  = mid(head);
        
        //first half
        Stack<Integer> stack = new Stack<>();
        while(curr!=mid){
            stack.add(curr.data);
            curr = curr.next;
        }
        
        //compare
        curr = (size(head)%2==0) ? mid: mid.next;
        while(curr!=null){
            if(curr.data != stack.pop()){
                return 0;
            }
            curr = curr.next;
        }
        return 1;
    }
    
    private static Node mid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private static int size(Node head){
        int size=0;
        Node curr = head;
        while(curr!=null){
            curr = curr.next;
            size++;
        }
        return size;
    }
    
    public static void main(String[] args) {
        //Odd
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(5);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(1);
        System.out.println("\nTestcase 1 o/p =>" + isPalinDrome(node));
        
        //Even
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(5);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(2);
        node.next.next.next.next.next = new Node(1);
        System.out.println("Testcase 2 o/p =>" + isPalinDrome(node));
        
        //False case
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(5);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(2);
        node.next.next.next.next.next = new Node(4);
        System.out.println("\nTestcase 2 o/p =>" + isPalinDrome(node));
    }
}
