package com.zhang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.dao.AdminDao;
import com.zhang.entity.Admin;
import com.zhang.entity.PageBean;

@Service
public class AdminService {

	@Resource
	private AdminDao adminDao;

	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public Admin login(String userName,String password){
		if(userName==""||userName==null||password==""||password==null){
			return null;
		}
		return adminDao.login(userName, password);
	}
	
	public boolean save(Admin admin){
		return adminDao.save(admin);
	}

	public boolean update(Admin admin) {
		return adminDao.update(admin);
	}
	
	public boolean changePassword(int id,String password) {
		return adminDao.changePassword(id, password);
	}

	public boolean delete(int id) {
		return adminDao.delete(id);
	}
	
	public List<Admin> find(PageBean pageBean,Admin s_admin){
		return adminDao.find(pageBean, s_admin);
	}
	
	public List<Admin> findAll(){
		return adminDao.findAll();
	}
	
	public Admin findByUserId(int id){
		return adminDao.findByUserId(id);
	}
}
