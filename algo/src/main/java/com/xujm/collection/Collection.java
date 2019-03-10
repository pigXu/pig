package com.xujm.collection;

/**
 * 集合接口
 *
 * @author xujm
 * @date 2018/10/25
 */
public interface Collection<T> {

  /**
   * 新增
   *
   * @param t 新增的元素
   */
  void add(T t);

  /***
   * 删除
   * @param t 删除的元素
   * @return 有删除返回删除的元素，没有返回null
   */
  T remove(T t);

  /**
   * get
   *
   * @param index 索引
   * @return 索引有值就返回索引对应的元素, 没有就返回null
   */
  T get(int index);
}
