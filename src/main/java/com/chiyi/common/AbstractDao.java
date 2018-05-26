package com.chiyi.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AbstractDao<T> {
    void insert(T t)throws Exception;

    void delete(@Param("key") String ukfield, @Param("value") Object value)throws Exception;

    void update(T t)throws Exception;

    T select(@Param("key") String ukfield, @Param("value") Object value)throws Exception;
    boolean exists(@Param("key") String ukfield, @Param("value") Object value)throws Exception;
    List<T> selectLike(@Param("key")String key)throws Exception;
}
