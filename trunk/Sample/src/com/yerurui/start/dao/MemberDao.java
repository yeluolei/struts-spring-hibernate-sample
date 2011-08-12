package com.yerurui.start.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yerurui.start.entity.Member;

public class MemberDao extends HibernateDaoSupport {
	
	public void save(Member member){
		Transaction transaction = null;
		Session session =getSession();
		try {
			transaction = session.beginTransaction();
			session.save(member);
			transaction.commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName , Object value){
		String queryString = "from Member as model where model." + propertyName +"= ?";
		Query query = getSession().createQuery(queryString);
		query.setParameter(0,value);
		return (List) query.list();
	}
}
