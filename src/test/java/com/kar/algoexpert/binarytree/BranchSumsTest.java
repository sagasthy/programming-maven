package com.kar.algoexpert.binarytree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BranchSumsTest extends BranchSums.BinaryTree {

    BranchSumsTest(int value) {
        super(value);
    }

    BranchSumsTest insert(List<Integer> values) {
        return insert(values, 0);
    }

    BranchSumsTest insert(List<Integer> values, int i) {
        if (i >= values.size()) return null;

        List<BranchSumsTest> queue = new ArrayList<BranchSumsTest>();
        queue.add(this);
        while (queue.size() > 0) {
            BranchSumsTest current = queue.get(0);
            queue.remove(0);
            if (current.left == null) {
                current.left = new BranchSumsTest(values.get(i));
                break;
            }
            queue.add((BranchSumsTest) current.left);
            if (current.right == null) {
                current.right = new BranchSumsTest(values.get(i));
                break;
            }
            queue.add((BranchSumsTest) current.right);
        }
        insert(values, i + 1);
        return this;
    }


    @Test
    public void TestCase1() {
        BranchSumsTest tree = new BranchSumsTest(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(15, 16, 18, 10, 11));
        assertEquals(BranchSums.branchSums(tree), expected, "need to rewrite this test");
    }
}