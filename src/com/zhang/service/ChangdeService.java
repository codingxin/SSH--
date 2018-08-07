package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.ChangdeDao;
import com.zhang.entity.Changde;
import com.zhang.entity.PageBean;

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

	public boolean save(Changde Changde){
		return ChangdeDao.save(Changde);
	}

	public boolean update(Changde Changde) {
		return ChangdeDao.update(Changde);
	}

	public boolean delete(int id) {
		return ChangdeDao.delete(id);
	}

	public List<Changde> find(PageBean pageBean,Changde s_Changde){
		return ChangdeDao.find(pageBean, s_Changde);
	}
	
	public List<Changde> findAll(){
		return ChangdeDao.findAll();
	}
	
	public Changde findById(int id){
		return ChangdeDao.findById(id);
	}
	
}
