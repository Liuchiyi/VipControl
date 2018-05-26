package com.chiyi.vip.web.handler;

import com.chiyi.vip.entity.VIPRankEntity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public abstract class AbstractHandler {

	public VIPRankEntity getRank(HttpServletRequest req, int rank){
		Map<Integer, VIPRankEntity> rankMap=(Map<Integer, VIPRankEntity>)req.getServletContext().getAttribute("RANKS-MAP");
		return rankMap.get(rank);
	}
	
}
