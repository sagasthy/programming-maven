package com.kar.algoexpert.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OutcoPractice2 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.right.right = new Node(6);

        // System.out.println(root);
        // System.out.println(reverse(root));

        Node root2 = new Node(5);
        root2.left = new Node(2);
        root2.right = new Node(7);
        root2.right.left = new Node(4);
        root2.right.right = new Node(8);
        root2.right.right = new Node(9);

        // System.out.println(isValidBst(root2));

        // System.out.println(longestPathInBst(root));

        // System.out.println(lca(root2, 4, 9).value);

        System.out.println(bfs(root));
    }

    public static List<Integer> bfs(Node root) {
        if(root == null) return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            result.add(curr.value);

            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }

        return result;
    }

    public static Node lca(Node root, int num1, int num2) {
        if(root == null)
            return null;

        if(root.value == num1 || root.value == num2) {
            return root;
        }

        Node left = lca(root.left, num1, num2);
        Node right = lca(root.right, num1, num2);

        if(left != null && right != null)
            return root;
        
        return left == null ? right : left;
    }

    public static Node reverse(Node root) {
        if(root.left != null)
            reverse(root.left);
        if(root.right != null)
            reverse(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        return root;
    }

    public static boolean isValidBst(Node root) {
        if(root == null)
            return true;

        if(root.left != null && root.value < root.left.value)
            return false;
        
        if(root.right != null && root.value > root.right.value)
            return false;

        if(!isValidBst(root.left) || !isValidBst(root.right))
            return false;

        return true;
    }

    public static int longestPathInBst(Node root) {
        if(root == null)
            return 0;
        int leftPath = longestPathInBst(root.left);
        int rightPath = longestPathInBst(root.right);

        System.out.println("node: " + root.value + ", left: " + leftPath + ", right: " + rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }
}

class Node {
    int value;
    Node left;
    Node right;
    
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
    }
    
}
