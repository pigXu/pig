package com.xujm.collection;

/**
 * 单向链表
 * @author xujm
 * @date 2018/10/25
 */
public class SinglyLinkedList<T> implements Collection<T> {

    private Node<T> head;

    @Override
    @SuppressWarnings("unchecked")
    public void add(T t){
        if (null == head) {
            head = new Node(null, t);
        }else{
            Node last= getLast();
            last.next=new Node(null,t);
        }
    }

    @Override
    public T remove(T t){
        if (null == head) {
            return null;
        }
        if (head.val.equals(t)) {
            head = head.next;
            return t;
        }
        Node pre = head;
        while (null != pre.next){
            if(pre.next.val.equals(t)){
                pre.next=pre.next.next;
                return t;
            }else{
                pre=pre.next;
            }
        }
        return null;
    }

    private Node getLast() {
        Node last = head;
        while (null != last.next) {
            last = last.next;
        }
        return last;
    }

    @Override
    public T get(int index){
        Node<T> node = head;
        int i=0;
        while (null != node){
            if(i==index){
                return node.val;
            }else {
                node=node.next;
                i++;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("list is:");
        Node node = head;
        while (null != node){
            sb.append(node.val);
            sb.append(",");
            node=node.next;
        }
        return sb.toString();
    }

    private static class Node<T> {

        private Node<T> next;
        private T val;

        public Node(Node<T> next, T val) {
            this.next = next;
            this.val = val;
        }
    }
}
