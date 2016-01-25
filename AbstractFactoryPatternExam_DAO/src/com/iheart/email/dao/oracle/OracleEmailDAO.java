package com.iheart.email.dao.oracle;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.iheart.email.dao.EmailDAO;
import com.iheart.email.entity.Email;

public class OracleEmailDAO implements EmailDAO {
	private SqlSessionFactory sqlSessionFactory;

	public OracleEmailDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public int insertEmail(List<Email> emailList) {
		// TODO Auto-generated method stub
		// SqlSession session = sqlSessionFactory.openSession(false);
		// int result = 0;
		// try {
		// // 오토커밋 사용하지 않음
		// result = session.insert("User.insertUser", user);
		// 이런식으로 사용함...
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
