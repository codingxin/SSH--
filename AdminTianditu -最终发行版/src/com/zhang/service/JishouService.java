package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.JishouDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;

@Service
public class JishouService {

	@Resource
	private JishouDao jishouDao;

	
	public JishouDao getJishouDao() {
		return jishouDao;
	}
 
	public void setJishouDao(JishouDao JishouDao) {
		this.jishouDao = JishouDao;
	}

	public boolean save(Tianditu Jishou){
		return jishouDao.save(Jishou);
	}

	public boolean update(Tianditu Jishou) {
		return jishouDao.update(Jishou);
	}

	public boolean delete(int id) {
		return jishouDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Jishou){
		return jishouDao.find(pageBean, s_Jishou);
	}
	
	public List<Tianditu> findAll(){
		return jishouDao.findAll();
	}
	
	public Tianditu findById(int id){
		return jishouDao.findById(id);
	}
	
}
