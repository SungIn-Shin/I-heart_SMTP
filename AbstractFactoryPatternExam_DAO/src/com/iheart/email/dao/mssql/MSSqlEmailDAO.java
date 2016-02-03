package com.iheart.email.dao.mssql;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.iheart.email.dao.EmailDAO;
import com.iheart.email.entity.Email;

public class MSSqlEmailDAO implements EmailDAO {

	private SqlSessionFactory sqlSessionFactory;

	public MSSqlEmailDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public int insertEmail(List<Email> emailList) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = 0;
		try {
			result = session.insert("email.insertEmail", emailList);
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<Email> selectAllEmailList() {
		List<Email> reuslt = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			reuslt = session.selectList("email.selectAllEmailList");
		} finally {
			session.close();
		}
		return reuslt;
	}

	@Override
	public List<Email> selectEmailList(String senderName) {
		return null;
	}

}
