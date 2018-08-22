package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.HuaihuaDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;

@Service
public class HuaihuaService {

	@Resource
	private HuaihuaDao HuaihuaDao;

	
	public HuaihuaDao getHuaihuaDao() {
		return HuaihuaDao;
	}
 
	public void setHuaihuaDao(HuaihuaDao HuaihuaDao) {
		this.HuaihuaDao = HuaihuaDao;
	}

	public boolean save(Tianditu Huaihua){
		return HuaihuaDao.save(Huaihua);
	}

	public boolean update(Tianditu Huaihua) {
		return HuaihuaDao.update(Huaihua);
	}

	public boolean delete(int id) {
		return HuaihuaDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Huaihua){
		return HuaihuaDao.find(pageBean, s_Huaihua);
	}
	
	public List<Tianditu> findAll(){
		return HuaihuaDao.findAll();
	}
	
	public Tianditu findById(int id){
		return HuaihuaDao.findById(id);
	}
	
}
