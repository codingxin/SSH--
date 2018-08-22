package com.zhang.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zhang.entity.Changde;
import com.zhang.entity.PageBean;

@Repository
public class ChangdeDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	@Resource
	private SessionFactory sessionFactory;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Changde changde) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(changde);
		tx.commit();
		session.close();
		return true;
	}

	public boolean update(Changde changde) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.merge(changde);
		tx.commit();
		session.close();
		return true;
	}

	public boolean delete(int id) {
		Changde changde = this.findById(id);
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.delete(changde);
		tr.commit();
		session.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Changde> find(PageBean pageBean, Changde s_changde) {
		//from +  Entity 实体类名称
		StringBuffer sb = new StringBuffer("from Changde");
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(sb.toString());
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getPageSize());
		List<Changde> changdeList = q.list();
		tx.commit();
		session.close();
		return changdeList;
	}

	@SuppressWarnings("unchecked")
	public List<Changde> findAll() {
		String queryString = "from Changde";
		return (List<Changde>) this.hibernateTemplate.find(queryString);
	}

	public Changde findById(int id) {
		return (Changde) this.hibernateTemplate.get(Changde.class, id);
	}
}
