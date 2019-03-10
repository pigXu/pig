package com.xujm.collection;

/**
 * 双向循环链表
 *
 * @author xujm
 * @date 2018/10/26
 */
public class LinkedList<T> implements Collection<T> {

  private Node<T> tail;
  private Node<T> head;

  @Override
  @SuppressWarnings("unchecked")
  public void add(T t) {
    if (null == head) {
      head = new Node(null, null, t);
      tail = head;
    } else {
      Node newNode = new Node(tail, null, t);
      tail.next = newNode;
      tail = newNode;
    }
  }

  @Override
  public T remove(T t) {
    Node<T> node = get(t);
    if (null == node) {
      return null;
    }

    if (null == node.pre) {
      head = node.next;
    } else {
      node.pre.next = node.next;
    }

    if (null == node.next) {
      tail = node.pre;
    } else {
      node.next.pre = node.pre;
    }
    return t;
  }

  private Node<T> get(T t) {
    Node<T> node = head;
    while (null != node) {
      if (node.val.equals(t)) {
        return node;
      } else {
        node = node.next;
      }
    }
    return null;
  }

  @Override
  public T get(int index) {
    int i = 0;
    Node<T> node = head;
    while (null != node) {
      if (index == i) {
        return node.val;
      } else {
        node = node.next;
        i++;
      }
    }
    return null;
  }

  private static class Node<T> {

    private Node<T> pre;
    private Node<T> next;
    private T val;

    public Node(Node<T> pre, Node<T> next, T val) {
      this.pre = pre;
      this.next = next;
      this.val = val;
    }
  }
}
