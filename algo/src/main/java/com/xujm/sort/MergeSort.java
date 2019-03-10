package com.xujm.sort;

/**
 * 归并排序
 *
 * @author xujm
 * @date 2018/11/2
 */
public class MergeSort implements Sort {

  @Override
  public void sort(int[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  private void mergeSort(int[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    int mid = getMid(start, end);
    mergeSort(array, start, mid);
    mergeSort(array, mid + 1, end);
    merge(array, start, mid, mid + 1, end);
  }

  private void merge(int[] array, int leftStart, int leftEnd, int rightStart, int rightEnd) {
    int[] temp = new int[rightEnd - leftStart + 1];
    int leftStartTemp = leftStart;
    for (int i = 0; i < temp.length; i++) {
      if (leftStart > leftEnd) {
        System.arraycopy(array, rightStart, temp, i, rightEnd - rightStart + 1);
        break;
      }
      if (rightStart > rightEnd) {
        System.arraycopy(array, leftStart, temp, i, leftEnd - leftStart + 1);
        break;
      }
      if (array[leftStart] > array[rightStart]) {
        temp[i] = array[rightStart];
        rightStart++;
      } else {
        temp[i] = array[leftStart];
        leftStart++;
      }
    }

    System.arraycopy(temp, 0, array, leftStartTemp, temp.length);
  }

  private int getMid(int start, int end) {
    return (start + end) >>> 1;
  }
}
