package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.ZhuzhouDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;


@Service
public class ZhuzhouService {

	@Resource
	private ZhuzhouDao ZhuzhouDao;

	
	public ZhuzhouDao getZhuzhouDao() {
		return ZhuzhouDao;
	}
 
	public void setZhuzhouDao(ZhuzhouDao ZhuzhouDao) {
		this.ZhuzhouDao = ZhuzhouDao;
	}

	public boolean save(Tianditu Zhuzhou){
		return ZhuzhouDao.save(Zhuzhou);
	}

	public boolean update(Tianditu Zhuzhou) {
		return ZhuzhouDao.update(Zhuzhou);
	}

	public boolean delete(int id) {
		return ZhuzhouDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Zhuzhou){
		return ZhuzhouDao.find(pageBean, s_Zhuzhou);
	}
	
	public List<Tianditu> findAll(){
		return ZhuzhouDao.findAll();
	}
	
	public Tianditu findById(int id){
		return ZhuzhouDao.findById(id);
	}
	
}
