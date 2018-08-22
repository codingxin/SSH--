package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.HengyangDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;

@Service
public class HengyangService {

	@Resource
	private HengyangDao HengyangDao;

	
	public HengyangDao getHengyangDao() {
		return HengyangDao;
	}
 
	public void setHengyangDao(HengyangDao HengyangDao) {
		this.HengyangDao = HengyangDao;
	}

	public boolean save(Tianditu Hengyang){
		return HengyangDao.save(Hengyang);
	}

	public boolean update(Tianditu Hengyang) {
		return HengyangDao.update(Hengyang);
	}

	public boolean delete(int id) {
		return HengyangDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Hengyang){
		return HengyangDao.find(pageBean, s_Hengyang);
	}
	
	public List<Tianditu> findAll(){
		return HengyangDao.findAll();
	}
	
	public Tianditu findById(int id){
		return HengyangDao.findById(id);
	}
	
}
