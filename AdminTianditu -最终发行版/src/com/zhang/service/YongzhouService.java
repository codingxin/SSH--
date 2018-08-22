package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.YongzhouDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;


@Service
public class YongzhouService {

	@Resource
	private YongzhouDao yongzhouDao;

	
	public YongzhouDao getYongzhouDao() {
		return yongzhouDao;
	}
 
	public void setYongzhouDao(YongzhouDao YongzhouDao) {
		this.yongzhouDao = YongzhouDao;
	}

	public boolean save(Tianditu Yongzhou){
		return yongzhouDao.save(Yongzhou);
	}

	public boolean update(Tianditu Yongzhou) {
		return yongzhouDao.update(Yongzhou);
	}

	public boolean delete(int id) {
		return yongzhouDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Yongzhou){
		return yongzhouDao.find(pageBean, s_Yongzhou);
	}
	
	public List<Tianditu> findAll(){
		return yongzhouDao.findAll();
	}
	
	public Tianditu findById(int id){
		return yongzhouDao.findById(id);
	}
	
}
