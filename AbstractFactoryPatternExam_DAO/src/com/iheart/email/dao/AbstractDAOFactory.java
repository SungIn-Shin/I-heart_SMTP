package com.iheart.email.dao;

import com.iheart.email.dao.mssql.MSSqlDAOFactory;
import com.iheart.email.dao.mysql.MySqlDAOFactory;
import com.iheart.email.dao.oracle.OracleDAOFactory;

//추상 DAO 팩토리 클래스
public abstract class AbstractDAOFactory {
	// 지원하는 DAO 리스트
	// 1. Oracle 2. MySQL, 3. MSSQL
	public static final String ORACLE = "ORACLE";
	public static final String MYSQL = "MYSQL";
	public static final String MSSQL = "MSSQL";
	
	public abstract EmailDAO getEmailDAO();

	public static AbstractDAOFactory getDAOFactory(String whichFactory){
		
		switch(whichFactory.toUpperCase()){
		case ORACLE : 
			return new OracleDAOFactory();
		case MYSQL :
			return new MySqlDAOFactory();
		case MSSQL :
			return new MSSqlDAOFactory();
		default :
			throw new NullPointerException("지원하지 않는 DB입니다.");
		}
	}
}
