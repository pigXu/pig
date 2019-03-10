package com.xujm;

import com.xujm.sort.BubbleSort;
import com.xujm.sort.CountingSort;
import com.xujm.sort.InsertionSort;
import com.xujm.sort.MergeSort;
import com.xujm.sort.QuickSort;
import com.xujm.sort.SelectSort;
import com.xujm.sort.Sort;
import org.junit.Test;

/**
 * 排序测试
 *
 * @author xujm
 * @date 2018/10/29
 */
public class SortTest {

  @Test
  public void testCountingSort() {
    test(new CountingSort());
  }


  @Test
  public void testQuickSort() {
    test(new QuickSort());
  }

  @Test
  public void testMergeSort() {
    test(new MergeSort());
  }

  @Test
  public void testSelectSort() {
    test(new SelectSort());
  }

  @Test
  public void testBubbleSort() {
    test(new BubbleSort());
  }

  @Test
  public void testInsertionSort() {
    test(new InsertionSort());
  }

  private void test(Sort sort) {
    int[] array = {2, 3, 1, 6, 5, 9, 4, 7, 8};
    sort.sort(array);

    System.out.print(sort.getClass() + " sort result:");
    for (int i : array) {
      System.out.print(i + ",");
    }
    System.out.println();
  }
}
