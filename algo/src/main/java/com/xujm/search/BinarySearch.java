package com.xujm.search;

/**
 * 二分查找
 *
 * @author xujm
 * @date 2018/11/03
 */
public class BinarySearch {
  /**
   * 查找值等于给定值
   *
   * @param array 升序的数组
   */
  public static int search(int[] array, int value) {
    int start = 0;
    int end = array.length - 1;
    while (start <= end) {
      int mid = (start + end) >>> 1;
      if (array[mid] > value) {
        end = mid - 1;
      } else if (array[mid] < value) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  /**
   * 查找第一个值等于给定值的元素
   */
  public static int search1(int[] array, int value) {
    int start = 0;
    int end = array.length - 1;
    while (start <= end) {
      int mid = (start + end) >>> 1;
      if (array[mid] > value) {
        end = mid - 1;
      } else if (array[mid] < value) {
        start = mid + 1;
      } else {
        if (mid < 1) {
          return mid;
        }
        if (array[mid - 1] != value) {
          return mid;
        }
        if (mid > 1) {
          end = mid - 1;
        } else {
          return mid - 1;
        }
      }
    }
    return -1;
  }

  /**
   * 查找最后一个值等于给定值的元素
   */
  public static int search2(int[] array, int value) {
    int start = 0;
    int end = array.length - 1;
    while (start <= end) {
      int mid = (start + end) >>> 1;
      if (array[mid] > value) {
        end = mid - 1;
      } else if (array[mid] < value) {
        start = mid + 1;
      } else {
        if (mid > array.length - 2) {
          return mid;
        }
        if (array[mid + 1] != value) {
          return mid;
        }
        if (mid > array.length - 3) {
          return mid + 1;
        } else {
          start = mid + 1;
        }
      }
    }
    return -1;
  }

  /**
   * 查找第一个大于等于给定值的元素
   */
  public static int search3(int[] array, int value) {
    int start = 0;
    int end = array.length - 1;
    while (start <= end) {
      int mid = (start + end) >>> 1;
      if (array[mid] < value) {
        start = mid + 1;
      } else {
        if (mid < 1) {
          return mid;
        }
        if (array[mid - 1] < value) {
          return mid;
        }
        if (mid > 1) {
          end = mid - 1;
        } else {
          return mid - 1;
        }
      }
    }
    return -1;
  }

  /**
   * 查找最后一个小于等于给定值的元素
   */
  public static int search4(int[] array, int value) {
    int start = 0;
    int end = array.length - 1;
    while (start <= end) {
      int mid = (start + end) >>> 1;
      if (array[mid] > value) {
        end = mid - 1;
      } else {
        if (mid > array.length - 2) {
          return mid;
        }
        if (array[mid + 1] > value) {
          return mid;
        }
        if (mid > array.length - 3) {
          return mid + 1;
        } else {
          start = mid + 1;
        }
      }
    }
    return -1;
  }
}
