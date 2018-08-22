package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.LoudiDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;

@Service
public class LoudiService {

	@Resource
	private LoudiDao loudiDao;

	
	public LoudiDao getLoudiDao() {
		return loudiDao;
	}
 
	public void setLoudiDao(LoudiDao LoudiDao) {
		this.loudiDao = LoudiDao;
	}

	public boolean save(Tianditu Loudi){
		return loudiDao.save(Loudi);
	}

	public boolean update(Tianditu Loudi) {
		return loudiDao.update(Loudi);
	}

	public boolean delete(int id) {
		return loudiDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Loudi){
		return loudiDao.find(pageBean, s_Loudi);
	}
	
	public List<Tianditu> findAll(){
		return loudiDao.findAll();
	}
	
	public Tianditu findById(int id){
		return loudiDao.findById(id);
	}
	
}
