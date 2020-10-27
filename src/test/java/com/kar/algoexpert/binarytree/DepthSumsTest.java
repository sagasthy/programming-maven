package com.kar.algoexpert.binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthSumsTest {

    @Test
    public void testNodeDepths(){
        DepthSums.BinaryTree root = new DepthSums.BinaryTree(1);
        root.left = new DepthSums.BinaryTree(2);
        root.left.left = new DepthSums.BinaryTree(4);
        root.left.left.left = new DepthSums.BinaryTree(8);
        root.left.left.right = new DepthSums.BinaryTree(9);
        root.left.right = new DepthSums.BinaryTree(5);
        root.right = new DepthSums.BinaryTree(3);
        root.right.left = new DepthSums.BinaryTree(6);
        root.right.right = new DepthSums.BinaryTree(7);

        int actual = DepthSums.nodeDepths(root);
        int expected = 16;

        assertEquals(expected, actual);
    }

}