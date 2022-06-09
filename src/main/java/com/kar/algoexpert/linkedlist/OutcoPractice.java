package com.kar.algoexpert.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class OutcoPractice {
    private static void printForward(Node root) {
        Node curr = root;

        while(curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

    private static void printBackward(Node node) {
        if(node == null) return;

        printBackward(node.next);
        
        System.out.println(node.value);
    }

    // 1 -> 5 -> 7 -> 10 -> null
    // null <- 1 <- 5 <- 7 <- 10
    private static Node reverse(Node root) {
        Node curr = root;
        Node prev = null;
        Node temp = null;
        
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    private static void printLinkedList(Node root) {
        Node curr = root;

        while(curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
    }

    // 1 -> 5 -> 7 -> 10 -> 12 -> 15
    // 1 -> 12 -> 7 -> 10 -> 5 -> 15
    private static Node swapNodes(Node root, int a, int b) {
        Node curr = root;
        // Placeholder node for traversing
        Node ph = new Node(0);
        ph.next = curr;
        Node parent = ph;
        Node currA = null;
        Node currB = null;
        Node parentA = null;
        Node parentB = null;

        while(curr != null) {
            if(curr.value == a && currA == null) {
                currA = curr;
                parentA = parent;
            }

            if(curr.value == b && currB == null) {
                currB = curr;
                parentB = parent;
            }

            curr = curr.next;
            parent = parent.next;
        }

        if(currA == null || currB == null) return root;

        parentA.next = currB;
        parentB.next = currA;

        Node temp = currA.next;
        currA.next = currB.next;
        currB.next = temp;

        return ph.next;
    }

    public static int getRandom(Node head) {
        Node current = head;
        List<Node> nodes = new ArrayList<Node>();
        
        while(current != null) {
            nodes.add(current);
            current = current.next;
        }
        
        int randomIndex = (int) (Math.random() * nodes.size());
        
        return nodes.get(randomIndex).value;
    }

    private static int getIntersectionNode(Node headA, Node headB) {
        Node p1 = headA;
        Node p2 = headB;
        while(p1 != p2){
            System.out.println("p1: " + (p1 == null ? "" : p1.value) + " p2: " + (p2 == null ? "" :p2.value));
            if(p1 == null)
                p1 = headB;
            else
                p1 = p1.next;
            
            if(p2 == null)
                p2 = headA;
            else 
                p2 = p2.next;
        }

        return p1.value;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(5);
        root.next.next = new Node(7);
        root.next.next.next = new Node(10);

        // printForward(root);
        // printBackward(root);
        // System.out.println(reverse(root));

        Node root1 = new Node(1);
        root1.next = new Node(5);
        root1.next.next = new Node(7);
        root1.next.next.next = new Node(10);
        root1.next.next.next.next = new Node(12);
        root1.next.next.next.next.next = new Node(15);

        // System.out.println(swapNodes(root1, 5, 12));

        // int[] arr = {1,2,3,4,5,6,7,8,9,10};
        // int random = (int) (Math.random() * arr.length);
        // System.out.println(random);

        // List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        // List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(5,4,3,2,1));

        // Stack<Integer> stack = new Stack<Integer>();

        // for(int num: l1) {
        //     stack.push(num);
        // }

        // while(!stack.isEmpty()) {
        //     System.out.println(stack.pop());
        // }

        // System.out.println(getRandom(root1));

        Node head1 = new Node(4);
        head1.next = new Node(1);
        head1.next.next = new Node(8);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(1);
        head2.next.next.next = head1.next.next;

        System.out.println(getIntersectionNode(head1, head2));

    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + ", next=" + next + "]";
    }    
}