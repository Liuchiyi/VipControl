package com.chiyi.vip.dao;

import java.util.List;

import com.chiyi.vip.entity.VIPRankEntity;

public interface VIPRankDao {
	List<VIPRankEntity> selectAll()throws Exception;
}
