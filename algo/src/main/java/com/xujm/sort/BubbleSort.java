package com.xujm.sort;

import com.xujm.utils.Utils;

/**
 * 冒泡排序
 *
 * @author xujm
 * @date 2018/10/29
 */
public class BubbleSort implements Sort {

  @Override
  public void sort(int[] array) {
    boolean flag = false;
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] > array[j]) {
          Utils.swap(array, i, j);
          flag = true;
        }
      }

      if (!flag) {
        break;
      }
    }
  }
}
