package com.iheart.email.dao.mysql;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.iheart.email.dao.EmailDAO;
import com.iheart.email.entity.Email;

public class MySqlEmailDAO implements EmailDAO {
	
	private SqlSessionFactory sqlSessionFactory;

	public MySqlEmailDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public int insertEmail(List<Email> emailList) {
		// TODO Auto-generated method stub
		return 0;
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
