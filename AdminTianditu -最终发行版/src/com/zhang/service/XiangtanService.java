package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.XiangtanDao;
import com.zhang.entity.PageBean;
import com.zhang.entity.Tianditu;

@Service
public class XiangtanService {

	@Resource
	private XiangtanDao xiangtanDao;

	
	public XiangtanDao getXiangtanDao() {
		return xiangtanDao;
	}
 
	public void setXiangtanDao(XiangtanDao XiangtanDao) {
		this.xiangtanDao = XiangtanDao;
	}

	public boolean save(Tianditu Xiangtan){
		return xiangtanDao.save(Xiangtan);
	}

	public boolean update(Tianditu Xiangtan) {
		return xiangtanDao.update(Xiangtan);
	}

	public boolean delete(int id) {
		return xiangtanDao.delete(id);
	}

	public List<Tianditu> find(PageBean pageBean,Tianditu s_Xiangtan){
		return xiangtanDao.find(pageBean, s_Xiangtan);
	}
	
	public List<Tianditu> findAll(){
		return xiangtanDao.findAll();
	}
	
	public Tianditu findById(int id){
		return xiangtanDao.findById(id);
	}
	
}
