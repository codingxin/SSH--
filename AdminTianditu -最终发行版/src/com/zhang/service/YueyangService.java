package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.YueyangDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;


@Service
public class YueyangService {

	@Resource
	private YueyangDao YueyangDao;

	
	public YueyangDao getYueyangDao() {
		return YueyangDao;
	}
 
	public void setYueyangDao(YueyangDao YueyangDao) {
		this.YueyangDao = YueyangDao;
	}

	public boolean save(Tianditu Yueyang){
		return YueyangDao.save(Yueyang);
	}

	public boolean update(Tianditu Yueyang) {
		return YueyangDao.update(Yueyang);
	}

	public boolean delete(int id) {
		return YueyangDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Yueyang){
		return YueyangDao.find(pageBean, s_Yueyang);
	}
	
	public List<Tianditu> findAll(){
		return YueyangDao.findAll();
	}
	
	public Tianditu findById(int id){
		return YueyangDao.findById(id);
	}
	
}
