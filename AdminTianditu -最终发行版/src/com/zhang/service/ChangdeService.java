package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.ChangdeDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;

@Service
public class ChangdeService {

	@Resource
	private ChangdeDao ChangdeDao;

	
	public ChangdeDao getChangdeDao() {
		return ChangdeDao;
	}
 
	public void setChangdeDao(ChangdeDao ChangdeDao) {
		this.ChangdeDao = ChangdeDao;
	}

	public boolean save(Tianditu Changde){
		return ChangdeDao.save(Changde);
	}

	public boolean update(Tianditu Changde) {
		return ChangdeDao.update(Changde);
	}

	public boolean delete(int id) {
		return ChangdeDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Changde){
		return ChangdeDao.find(pageBean, s_Changde);
	}
	
	public List<Tianditu> findAll(){
		return ChangdeDao.findAll();
	}
	
	public Tianditu findById(int id){
		return ChangdeDao.findById(id);
	}
	
}
