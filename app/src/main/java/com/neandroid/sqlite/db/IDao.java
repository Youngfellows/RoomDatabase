package com.neandroid.sqlite.db;

import java.util.List;

/**
 * 定义抽象的接口
 *
 * @param <T>
 */
public interface IDao<T> {

    /**
     * 插入数据
     *
     * @param t
     */
    void insert(T t);

    /**
     * 删除数据
     *
     * @param t
     */
    void delete(T t);

    /**
     * 更新数据
     *
     * @param t
     */
    void update(T t);

    /**
     * 获取全部数据
     *
     * @return
     */
    List<T> getAll();

    /**
     * 通过ID查询
     *
     * @param id
     */
    T getById(int id);
}
