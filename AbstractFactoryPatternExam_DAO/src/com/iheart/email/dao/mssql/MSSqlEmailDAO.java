package com.iheart.email.dao.mssql;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.iheart.email.dao.EmailDAO;
import com.iheart.email.entity.Email;

public class MSSqlEmailDAO implements EmailDAO{
	
	private SqlSessionFactory sqlSessionFactory;
	
	public MSSqlEmailDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public int insertEmail(List<Email> emailList) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.insert("email.insertEmail", emailList);
		return result;
	}

	@Override
	public List<Email> selectAllEmailList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Email> selectEmailList(String senderName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
