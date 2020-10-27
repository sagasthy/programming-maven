package com.kar.algoexpert.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestInBstTest {

    @Test
    void findClosestValueInBst() {
        ClosestInBst.BST root = new ClosestInBst.BST(10);
        root.left = new ClosestInBst.BST(5);
        root.left.left = new ClosestInBst.BST(2);
        root.left.left.left = new ClosestInBst.BST(1);
        root.left.right = new ClosestInBst.BST(5);
        root.right = new ClosestInBst.BST(15);
        root.right.left = new ClosestInBst.BST(13);
        root.right.left.right = new ClosestInBst.BST(14);
        root.right.right = new ClosestInBst.BST(22);

        int expected = 13;
        int actual = ClosestInBst.findClosestValueInBst(root, 12);
        assertEquals(expected, actual, "closest doesn't match");
    }
}