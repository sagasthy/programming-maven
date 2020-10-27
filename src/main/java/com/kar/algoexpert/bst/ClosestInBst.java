package com.kar.algoexpert.bst;

public class ClosestInBst {
    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBstv2(tree, target, tree.value);
    }

    // Average: O(log n) time and O(1) space
    // Worst: O(n) time and O(1) space
    public static int findClosestValueInBstv1(BST tree, int target, int closest){
        BST currentNode = tree;

        while(currentNode != null){
            if(Math.abs(target - currentNode.value) < Math.abs(target - closest)){
                closest = currentNode.value;
            }

            if(target < currentNode.value){
                currentNode = currentNode.left;
            } else if(target > currentNode.value){
                currentNode = currentNode.right;
            } else{
                break;
            }
        }

        return closest;
    }

    // Average: O(log n) time and O(log n) space
    // Worst: O(n) time and O(n) space
    public static int findClosestValueInBstv2(BST tree, int target, int closest){
        if(Math.abs(target - tree.value) < Math.abs(target - closest)){
            closest = tree.value;
        }

        if(target > tree.value && tree.right != null){
            return findClosestValueInBstv2(tree.right, target, closest);
        } else if(target < tree.value && tree.left != null){
            return findClosestValueInBstv2(tree.left, target, closest);
        } else{
            return closest;
        }
    }

    public static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
