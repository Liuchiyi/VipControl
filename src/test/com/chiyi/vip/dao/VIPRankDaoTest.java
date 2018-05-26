package com.chiyi.vip.dao;

import com.chiyi.vip.entity.VIPRankEntity;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml"})
public class VIPRankDaoTest {

    @Resource
    private VIPRankDao v;
    @Test
    public void selectAll() {
        try {
            List<VIPRankEntity> list =v.selectAll();
            System.out.println(list.get(1).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}