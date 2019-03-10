package com.xujm.collection;

/**
 * 数组list
 *
 * @author xujm
 * @date 2018/10/25
 */
public class ArrayList<T> implements Collection<T> {

  private Object[] data;
  private int size;

  public ArrayList() {
    data = new Object[8];
  }

  public ArrayList(int size) {
    data = new Object[size];
  }

  @Override
  public void add(T t) {
    if (size == data.length) {
      Object[] temp = new Object[size * 2];
      System.arraycopy(data, 0, temp, 0, size);
      data = temp;
    }
    data[size] = t;
    size++;
  }

  @Override
  public T remove(T t) {
    int index = getIndex(t);
    if (index < 0) {
      return null;
    }
    System.arraycopy(data, index + 1, data, index, size - index - 1);
    size--;
    data[size] = null;
    return t;
  }

  private int getIndex(T t) {
    for (int i = 0; i < data.length; i++) {
      if (t.equals(data[i])) {
        return i;
      }
    }
    return -1;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T get(int index) {
    if (index >= size) {
      return null;
    }
    return (T) data[index];
  }
}
