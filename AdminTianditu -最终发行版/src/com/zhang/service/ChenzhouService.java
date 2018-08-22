package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.ChenzhouDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;


@Service
public class ChenzhouService {

	@Resource
	private ChenzhouDao chenzhouDao;

	
	public ChenzhouDao getChenzhouDao() {
		return chenzhouDao;
	}
 
	public void setChenzhouDao(ChenzhouDao ChenzhouDao) {
		this.chenzhouDao = ChenzhouDao;
	}

	public boolean save(Tianditu Chenzhou){
		return chenzhouDao.save(Chenzhou);
	}

	public boolean update(Tianditu Chenzhou) {
		return chenzhouDao.update(Chenzhou);
	}

	public boolean delete(int id) {
		return chenzhouDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Chenzhou){
		return chenzhouDao.find(pageBean, s_Chenzhou);
	}
	
	public List<Tianditu> findAll(){
		return chenzhouDao.findAll();
	}
	
	public Tianditu findById(int id){
		return chenzhouDao.findById(id);
	}
	
}
