package com.xujm.utils;

/**
 * 工具类
 *
 * @author xujm
 * @date 2018/11/03
 */
public class Utils {

  /**
   * 数组交换
   *
   * @param array 数组
   * @param i 数据交换索引
   * @param j 数据交换索引
   */
  public static void swap(int[] array, int i, int j) {
    if (i == j) {
      return;
    }
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  /**
   * 取start,mid,end的中间数放到end
   */
  public static int getPivot(int[] array, int start, int end) {
    int mid = (start + end) >>> 1;
    if (array[mid] < array[start]) {
      Utils.swap(array, mid, start);
    }
    if (array[end] < array[start]) {
      Utils.swap(array, start, end);
    }
    if (array[mid] < array[end]) {
      Utils.swap(array, mid, end);
    }
    return end;
  }
}
