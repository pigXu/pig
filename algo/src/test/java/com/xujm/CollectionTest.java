package com.xujm;

import com.xujm.collection.ArrayList;
import com.xujm.collection.Collection;
import com.xujm.collection.LinkedList;
import com.xujm.collection.SinglyLinkedList;
import org.junit.Test;

/**
 * 集合单位测试
 *
 * @author xujm
 * @date 2018/10/25
 */
public class CollectionTest {

  @Test
  public void testLinkedList() {
    test(new LinkedList<>());
  }

  @Test
  public void testSinglyLinkedList() {
    test(new SinglyLinkedList<>());
  }

  @Test
  public void testArrayList() {
    test(new ArrayList<>(1));
  }

  private void test(Collection<String> collection) {
    collection.add("a");
    collection.add("b");
    collection.add("c");

    assert "b".equals(collection.remove("b"));
    assert null == collection.remove("b");
    assert null == collection.remove("b");
    assert null == collection.remove("b");

    assert "a".equals(collection.remove("a"));

    assert null == collection.remove("d");

    assert "c".equals(collection.get(0));

    assert "c".equals(collection.remove("c"));
    assert null == collection.remove("c");
    assert null == collection.remove("c");

    assert null == collection.get(0);
  }
}
