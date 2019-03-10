package com.xujm;

import com.xujm.stack.ArrayStack;
import org.junit.Test;

public class StackTest {

  @Test
  public void test() {
    ArrayStack<String> stack = new ArrayStack<>(1);
    stack.push("a");
    stack.push("b");
    stack.push("c");

    assert "c".equals(stack.pop());
    assert "b".equals(stack.pop());
    assert "a".equals(stack.pop());
    assert null == stack.pop();
  }
}
