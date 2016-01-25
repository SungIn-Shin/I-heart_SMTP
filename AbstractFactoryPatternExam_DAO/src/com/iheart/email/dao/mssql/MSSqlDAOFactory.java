package com.iheart.email.dao.mssql;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.iheart.email.dao.AbstractDAOFactory;
import com.iheart.email.dao.EmailDAO;

public class MSSqlDAOFactory extends AbstractDAOFactory {
	
	private static SqlSessionFactory seqSessionFactory;
	
	public MSSqlDAOFactory() {
		try {
			String resource = "com/iheart/email/config/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			if(seqSessionFactory == null){
				seqSessionFactory = new SqlSessionFactoryBuilder().build(reader, AbstractDAOFactory.MSSQL);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public EmailDAO getEmailDAO() {
		return new MSSqlEmailDAO(seqSessionFactory);
	}
	
}
