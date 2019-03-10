package com.xujm.exercise;

import com.xujm.utils.Utils;
import org.junit.Test;

/**
 * 求无序数组中的第 K 大元素
 *
 * <p>我们选择数组区间 A[0…n-1] 的最后一个元素 A[n-1] 作为 pivot，对数组 A[0…n-1]
 * 原地分区，这样数组就分成了三部分，A[0…p-1]、A[p]、A[p+1…n-1]。 如果 p+1=K，那 A[p] 就是要求解的元素；如果 K>p+1, 说明第 K 大元素出现在
 * A[p+1…n-1] 区间，我们再按照上面的思路递归地在 A[p+1…n-1] 这个区间内查找。同理，如果 K<p+1, 说明第 K 大元素出现在 A[0,p-1] 区间
 *
 * <p>我们再来看，为什么上述解决思路的时间复杂度是 O(n)？第一次分区查找，我们需要对大小为 n 的数组执行分区操作，需要遍历 n 个元素。第二次分区查找，我们只需要对大小为 n/2
 * 的数组执行分区操作，需要遍历 n/2 个元素。依次类推，分区遍历元素的个数分别为、n/2、n/4、n/8、n/16.…...直到区间缩小为 1。
 *
 * <p>如果我们把每次分区遍历的元素个数加起来，就是：n+n/2+n/4+n/8+…+1。这是一个等比数列求和，最后的和等于 2n-1。所以，上述解决思路的时间复杂度就为 O(n)。
 */
public class TopNTest {

  @Test
  public void test() {
    int[] array = {2, 3, 1, 6, 5, 9, 4, 7, 8};
    System.out.println(getTopN(array, 6));
  }

  private int getTopN(int[] array, int top) {
    return getTopN(array, 0, array.length - 1, top);
  }

  private int getTopN(int[] array, int start, int end, int top) {
    int pivot = Utils.getPivot(array, start, end);
    int j = start;
    for (int i = start; i < end; i++) {
      if (array[i] < array[pivot]) {
        Utils.swap(array, i, j++);
      }
    }
    int pivotRank = end - j + 1;
    if (pivotRank == top) {
      return array[pivot];
    } else if (pivotRank > top) {
      return getTopN(array, j, end - 1, top);
    } else {
      return getTopN(array, start, j - 1, top - pivotRank);
    }
  }
}
