package com.xujm;

import com.xujm.search.BinarySearch;
import org.junit.Test;

public class BinarySearchTest {

  @Test
  public void test1() {
    int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
    assert 2 == BinarySearch.search(array, 2);
    System.out.println(BinarySearch.search(array, 9));
    assert 9 == BinarySearch.search(array, 9);
    assert 6 == BinarySearch.search(array, 6);
  }

  @Test
  public void test2() {
    int[] array = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9};
    assert 2 == BinarySearch.search1(array, 2);
    assert 10 == BinarySearch.search1(array, 9);
    assert 6 == BinarySearch.search1(array, 5);
    assert 3 == BinarySearch.search1(array, 3);
  }

  @Test
  public void test3() {
    int[] array = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9};
    assert 2 == BinarySearch.search2(array, 2);
    assert 13 == BinarySearch.search2(array, 9);
    assert 6 == BinarySearch.search2(array, 5);
    assert 4 == BinarySearch.search2(array, 3);
  }

  @Test
  public void test4() {
    int[] array = {0, 1, 2, 3, 3, 4, 6, 7, 8, 9, 9, 9, 9};
    assert 2 == BinarySearch.search3(array, 2);
    assert 9 == BinarySearch.search3(array, 9);
    assert 6 == BinarySearch.search3(array, 5);
    assert 3 == BinarySearch.search3(array, 3);
  }

  @Test
  public void test5() {
    int[] array = {0, 1, 2, 3, 3, 4, 6, 7, 8, 9, 9, 9, 9};
    assert 2 == BinarySearch.search4(array, 2);
    assert 12 == BinarySearch.search4(array, 9);
    assert 5 == BinarySearch.search4(array, 5);
    assert 4 == BinarySearch.search4(array, 3);
  }
}
