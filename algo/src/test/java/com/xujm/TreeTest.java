package com.xujm;

import com.xujm.tree.BinarySearchTree;
import org.junit.Test;

public class TreeTest {

    @Test
    public void testBinarySearchTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);

        System.out.println(tree.find(1));
        System.out.println(tree.find(2));
        System.out.println(tree.find(3));
        System.out.println(tree.find(4));
        System.out.println(tree.find(5));
        System.out.println(tree.find(6));
        tree.delete(2);
        tree.delete(4);
        System.out.println(tree.find(1));
        System.out.println(tree.find(2));
        System.out.println(tree.find(3));
        System.out.println(tree.find(4));
        System.out.println(tree.find(5));
        System.out.println(tree.find(6));
    }
}
