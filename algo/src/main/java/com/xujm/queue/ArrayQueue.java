package com.xujm.queue;

/**
 * 基于数组实现的有界队列
 *
 * @author xujm
 * @date 2018/10/29
 */
public class ArrayQueue<T> {

  private Object[] data;
  private int head;
  private int tail;
  private int size;

  public ArrayQueue(int capacity) {
    data = new Object[capacity];
  }

  /**
   * 入队
   */
  public boolean enqueue(T item) {
    //检查队列满
    if (size >= data.length) {
      return false;
    }
    data[tail] = item;
    tail++;
    if (tail >= data.length) {
      tail = 0;
    }
    size++;
    return true;
  }

  /**
   * 出队
   */
  @SuppressWarnings("unchecked")
  public T dequeue() {
    if (0 == size) {
      return null;
    }
    T result = (T) data[head];
    head++;
    if (head >= data.length) {
      head = 0;
    }
    size--;
    return result;
  }
}
