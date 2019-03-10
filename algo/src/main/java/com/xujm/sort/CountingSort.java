package com.xujm.sort;

/**
 * 计数排序
 *
 * @author xujm
 * @date 2018/11/03
 */
public class CountingSort implements Sort {

  @Override
  public void sort(int[] array) {
    //得到最大值max
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    //创建0-max的数组
    int[] c = new int[max + 1];
    for (int i = 0; i < c.length; i++) {
      c[i] = 0;
    }
    //计算每个元素的个数，放入 c 中
    for (int i = 0; i < array.length; i++) {
      c[array[i]] = c[array[i]] + 1;
    }
    //依次累加
    for (int i = 1; i < c.length; i++) {
      c[i] = c[i] + c[i - 1];
    }
    //临时数组
    int[] temp = new int[array.length];
    //计数排序的关键步骤，有点难理解
    for (int i = 0; i < array.length; i++) {
      int index = c[array[i]];
      temp[index - 1] = array[i];
      c[array[i]] = c[array[i]] - 1;
    }
    System.arraycopy(temp, 0, array, 0, array.length);
  }
}
