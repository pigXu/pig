package com.xujm;

import com.xujm.queue.ArrayQueue;
import org.junit.Test;

/**
 * 队列测试
 *
 * @author xujm
 * @date 2018/10/29
 */
public class ArrayQueueTest {

  @Test
  public void test() {
    ArrayQueue<String> queue = new ArrayQueue<>(3);
    assert queue.enqueue("a");
    assert queue.enqueue("b");
    assert queue.enqueue("c");
    assert !queue.enqueue("d");

    assert "a".equals(queue.dequeue());
    assert "b".equals(queue.dequeue());
    assert "c".equals(queue.dequeue());
    assert null == queue.dequeue();

    assert queue.enqueue("a");
    assert queue.enqueue("b");
    assert "a".equals(queue.dequeue());
    assert "b".equals(queue.dequeue());
    assert null == queue.dequeue();
  }
}
