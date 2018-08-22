package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.YiyangDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;


@Service
public class YiyangService {

	@Resource
	private YiyangDao yiyangDao;

	
	public YiyangDao getYiyangDao() {
		return yiyangDao;
	}
 
	public void setYiyangDao(YiyangDao YiyangDao) {
		this.yiyangDao = YiyangDao;
	}

	public boolean save(Tianditu Yiyang){
		return yiyangDao.save(Yiyang);
	}

	public boolean update(Tianditu Yiyang) {
		return yiyangDao.update(Yiyang);
	}

	public boolean delete(int id) {
		return yiyangDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Yiyang){
		return yiyangDao.find(pageBean, s_Yiyang);
	}
	
	public List<Tianditu> findAll(){
		return yiyangDao.findAll();
	}
	
	public Tianditu findById(int id){
		return yiyangDao.findById(id);
	}
	
}
