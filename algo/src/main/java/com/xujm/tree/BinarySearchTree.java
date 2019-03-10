package com.xujm.tree;

/**
 * 二叉查找数
 *
 * @author xujm
 * @date 2018/11/14
 */
public class BinarySearchTree {
    private Node tree;

    public void insert(int val) {
        Node newNode = new Node();
        newNode.data = val;
        if (null == tree) {
            tree = newNode;
            return;
        }
        Node node = tree;
        while (null != node) {
            if (node.data < val) {
                if (null == node.right) {
                    node.right = newNode;
                    return;
                } else {
                    node = node.right;
                }
            } else {
                if (null == node.left) {
                    node.left = newNode;
                    return;
                } else {
                    node = node.left;
                }
            }
        }
    }

    public Node find(int val) {
        Node node = tree;
        while (null != node) {
            if (node.data == val) {
                return node;
            } else if (node.data > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public void delete(int val) {
        //删除的节点
        Node p = tree;
        //删除的父节点
        Node pp = null;
        while (null != p) {
            if (p.data == val) {
                break;
            } else if (p.data < val) {
                pp = p;
                p = p.right;
            } else {
                pp = p;
                p = p.left;
            }
        }
        if (null == p) {
            return;
        }
        //删除节点有2个子节点
        if (null != p.left && null != p.right) {
            Node midP = p.right;
            Node midPP = p;
            while (null != midP.left) {
                midPP = midP;
                midP = midP.left;
            }
            p.data = midP.data;
            p = midP;
            pp = midPP;
        }
        //删除节点有1个子节点 删除节点没有子节点
        Node child = null;
        if (null != p.left) {
            child = p.left;
        } else if (null != p.right) {
            child = p.right;
        }

        if (null == pp) {
            tree = null;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
