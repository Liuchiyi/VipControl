package com.chiyi.vip.web.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.chiyi.vip.dao.VIPRankDao;
import com.chiyi.vip.entity.VIPRankEntity;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;



public class ApplicationListener extends ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		super.contextInitialized(evt);
		
		ServletContext sc=evt.getServletContext();
		//初始化系统数据
		try{
		this.initVipRank(sc);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void initVipRank(ServletContext sc)throws Exception{
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		//获取dao
		VIPRankDao rdao=ac.getBean(VIPRankDao.class);
		List<VIPRankEntity> ranks = rdao.selectAll();
		Map<Integer, VIPRankEntity> ranksMap=new HashMap<>();
		for (VIPRankEntity r : ranks) {
			ranksMap.put(r.getCode(), r);
		}
		sc.setAttribute("RANKS-MAP", ranksMap);
	}

}
