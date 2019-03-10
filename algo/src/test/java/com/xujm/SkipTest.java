package com.xujm;

import com.xujm.collection.SkipList;
import org.junit.Test;

public class SkipTest {
    @Test
    public void test() {
        SkipList list = new SkipList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        list.remove(2);
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
    }
}
