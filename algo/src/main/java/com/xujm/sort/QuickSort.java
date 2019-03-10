package com.xujm.sort;

import com.xujm.utils.Utils;

/**
 * 快速排序
 *
 * @author xujm
 * @date 2018/11/2
 */
public class QuickSort implements Sort {

  @Override
  public void sort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  private void quickSort(int[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    int p = partition(array, start, end);
    quickSort(array, start, p - 1);
    quickSort(array, p + 1, end);
  }

  private int partition(int[] array, int start, int end) {
    int pivot = Utils.getPivot(array, start, end);
    int j = start;
    for (int i = start; i < end; i++) {
      if (array[i] < array[pivot]) {
        Utils.swap(array, i, j++);
      }
    }
    Utils.swap(array, j, pivot);
    return j;
  }
}