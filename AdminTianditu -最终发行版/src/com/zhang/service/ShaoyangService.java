package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.ShaoyangDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;


@Service
public class ShaoyangService {

	@Resource
	private ShaoyangDao shaoyangDao;

	
	public ShaoyangDao getShaoyangDao() {
		return shaoyangDao;
	}
 
	public void setShaoyangDao(ShaoyangDao ShaoyangDao) {
		this.shaoyangDao = ShaoyangDao;
	}

	public boolean save(Tianditu Shaoyang){
		return shaoyangDao.save(Shaoyang);
	}

	public boolean update(Tianditu Shaoyang) {
		return shaoyangDao.update(Shaoyang);
	}

	public boolean delete(int id) {
		return shaoyangDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Shaoyang){
		return shaoyangDao.find(pageBean, s_Shaoyang);
	}
	
	public List<Tianditu> findAll(){
		return shaoyangDao.findAll();
	}
	
	public Tianditu findById(int id){
		return shaoyangDao.findById(id);
	}
	
}
