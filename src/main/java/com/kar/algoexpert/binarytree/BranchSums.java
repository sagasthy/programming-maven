package com.kar.algoexpert.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<Integer>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    private static void calculateBranchSums(BinaryTree tree, int runningSum, List<Integer> sums) {
        if(tree == null)
            return;

        runningSum = runningSum + tree.value;

        if(tree.left == null && tree.right == null){
            sums.add(runningSum);
            return;
        }

        calculateBranchSums(tree.left, runningSum, sums);
        calculateBranchSums(tree.right, runningSum, sums);
    }
}
