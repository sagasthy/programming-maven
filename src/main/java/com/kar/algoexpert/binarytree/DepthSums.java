package com.kar.algoexpert.binarytree;

public class DepthSums {
    public static int nodeDepths(BinaryTree root) {
        return calculateDepths(root, 0);
    }

    private static int calculateDepths(BinaryTree tree, int depthSum){
        if(tree == null)
            return 0;

        depthSum = depthSum + calculateDepths(tree.left, depthSum+1) + calculateDepths(tree.right, depthSum+1);

        return depthSum;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
