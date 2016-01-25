package com.iheart.email.dao.mysql;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.iheart.email.dao.AbstractDAOFactory;
import com.iheart.email.dao.EmailDAO;

public class MySqlDAOFactory extends AbstractDAOFactory {
	
	private static SqlSessionFactory seqSessionFactory;

	public MySqlDAOFactory() {
		// 
		try {
			String resource = "com/iheart/email/config/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			if(seqSessionFactory == null){
				seqSessionFactory = new SqlSessionFactoryBuilder().build(reader, AbstractDAOFactory.MYSQL);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public EmailDAO getEmailDAO() {
		// TODO Auto-generated method stub
		return new MySqlEmailDAO(seqSessionFactory);
	}

}
