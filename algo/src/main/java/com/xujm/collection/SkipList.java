package com.xujm.collection;

import java.util.Arrays;
import java.util.Random;

/**
 * 跳表
 *
 * @author xujm
 * @date 2018/11/12
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;
    private Random random = new Random();
    private int level = 1;
    private Node head = new Node();


    public void add(int val) {
        Node newNode = new Node();
        newNode.level = getRandomLevel();
        newNode.val = val;


        Node[] updateNodes = new Node[newNode.level + 1];
        for (int i = 0; i < newNode.level; i++) {
            updateNodes[i] = head;
        }

        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].val < val) {
                p = p.forwards[i];
            }
            if (i < newNode.level) {
                updateNodes[i] = p;
            }
        }

        for (int i = 0; i < newNode.level; i++) {
            if (i >= this.level) {
                break;
            }
            newNode.forwards[i] = updateNodes[i].forwards[i];
            updateNodes[i].forwards[i] = newNode;
        }

        if (newNode.level > this.level) {
            this.level = newNode.level;
        }
    }

    public void remove(int val) {
        Node[] updateNodes = new Node[level];
        for (int i = 0; i < level; i++) {
            updateNodes[i] = head;
        }
        Node node = head;
        for (int i = level - 1; i >= 0; i--) {
            while (node.forwards[i] != null && node.forwards[i].val < val) {
                node = node.forwards[i];
            }
            updateNodes[i] = node;
        }
        for (int i = level - 1; i >= 0; i--) {
            if (updateNodes[i].forwards[i] != null && updateNodes[i].forwards[i].val == val) {
                updateNodes[i].forwards[i] = updateNodes[i].forwards[i].forwards[i];
            }
        }
    }

    public Node get(int val) {
        Node node = head;
        for (int i = level - 1; i >= 0; i--) {
            while (node.forwards[i] != null && node.forwards[i].val < val) {
                node = node.forwards[i];
            }
        }
        if (node.forwards[0] != null && node.forwards[0].val == val) {
            return node.forwards[0];
        }
        return null;
    }

    private int getRandomLevel() {
        return random.nextInt(MAX_LEVEL - 1) + 1;
    }

    private static class Node {
        private int level;
        private int val = -1;
        private Node[] forwards = new Node[MAX_LEVEL];

        @Override
        public String toString() {
            return "Node{" +
                    "level=" + level +
                    ", val=" + val +
                    ", forwards=" + Arrays.toString(forwards) +
                    '}';
        }
    }
}
