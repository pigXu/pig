package com.xujm.stack;

/**
 * 数组栈
 *
 * @author xujm
 * @date 2018/10/26
 */
public class ArrayStack<T> {

  private Object[] data;
  private int size;

  public ArrayStack(int size) {
    data = new Object[size];
  }

  /**
   * 入栈
   */
  public boolean push(T item) {
    if (size == data.length) {
      Object[] temp = new Object[size * 2];
      System.arraycopy(data, 0, temp, 0, size);
      data = temp;
    }
    data[size] = item;
    size++;
    return true;
  }

  /**
   * 出栈
   */
  @SuppressWarnings("unchecked")
  public T pop() {
    if (0 == size) {
      return null;
    }
    size--;
    return (T) data[size];
  }
}
