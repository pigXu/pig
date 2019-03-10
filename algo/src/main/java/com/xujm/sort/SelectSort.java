package com.xujm.sort;

import com.xujm.utils.Utils;

/**
 * 选择排序
 *
 * @author xujm
 * @date 2018/11/2
 */
public class SelectSort implements Sort {

  @Override
  public void sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        Utils.swap(array, minIndex, i);
      }
    }
  }
}
