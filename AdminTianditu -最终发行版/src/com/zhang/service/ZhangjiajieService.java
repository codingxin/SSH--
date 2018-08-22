package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.ZhangjiajieDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;


@Service
public class ZhangjiajieService {

	@Resource
	private ZhangjiajieDao zhangjiajieDao;

	
	public ZhangjiajieDao getZhangjiajieDao() {
		return zhangjiajieDao;
	}
 
	public void setZhangjiajieDao(ZhangjiajieDao ZhangjiajieDao) {
		this.zhangjiajieDao = ZhangjiajieDao;
	}

	public boolean save(Tianditu Zhangjiajie){
		return zhangjiajieDao.save(Zhangjiajie);
	}

	public boolean update(Tianditu Zhangjiajie) {
		return zhangjiajieDao.update(Zhangjiajie);
	}

	public boolean delete(int id) {
		return zhangjiajieDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Zhangjiajie){
		return zhangjiajieDao.find(pageBean, s_Zhangjiajie);
	}
	
	public List<Tianditu> findAll(){
		return zhangjiajieDao.findAll();
	}
	
	public Tianditu findById(int id){
		return zhangjiajieDao.findById(id);
	}
	
}
