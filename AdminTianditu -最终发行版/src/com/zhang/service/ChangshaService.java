package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.ChangshaDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;

@Service
public class ChangshaService {

	@Resource
	private ChangshaDao ChangshaDao;

	
	public ChangshaDao getChangshaDao() {
		return ChangshaDao;
	}
 
	public void setChangshaDao(ChangshaDao ChangshaDao) {
		this.ChangshaDao = ChangshaDao;
	}

	public boolean save(Tianditu Changsha){
		return ChangshaDao.save(Changsha);
	}

	public boolean update(Tianditu Changsha) {
		return ChangshaDao.update(Changsha);
	}

	public boolean delete(int id) {
		return ChangshaDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Changsha){
		return ChangshaDao.find(pageBean, s_Changsha);
	}
	
	public List<Tianditu> findAll(){
		return ChangshaDao.findAll();
	}
	
	public Tianditu findById(int id){
		return ChangshaDao.findById(id);
	}
	
}
