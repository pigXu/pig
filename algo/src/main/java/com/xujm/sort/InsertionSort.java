package com.xujm.sort;

/**
 * 插入排序
 *
 * @author xujm
 * @date 2018/10/30
 */
public class InsertionSort implements Sort {

  @Override
  public void sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int value = array[i];
      int j = i - 1;
      for (; j >= 0; j--) {
        if (value < array[j]) {
          array[j + 1] = array[j];
        } else {
          break;
        }
      }
      array[j + 1] = value;
    }
  }
}
