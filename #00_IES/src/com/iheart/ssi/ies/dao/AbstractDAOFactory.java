package com.iheart.ssi.ies.dao;

import com.iheart.ssi.ies.dao.mariadb.MariaDBDAOFactory;
import com.iheart.ssi.ies.dao.mssql.MSSqlDAOFactory;
import com.iheart.ssi.ies.dao.oracle.OracleDAOFactory;

public abstract class AbstractDAOFactory {

	// DAO 지원 Type 
	public static final String ORACLE = "ORACLE";
	public static final String MARIADB = "MARIADB";
	public static final String MSSQL = "MSSQL";

	public abstract EmailDAO getEmailDAO();

	public abstract MemberDAO getMemberDAO();

	public abstract MonitoringDAO getMonitoringDAO();

	public static AbstractDAOFactory getDAOFactory(String whichFactory) {
		switch (whichFactory.toUpperCase()) {
		case ORACLE :
			return new OracleDAOFactory();
		case MARIADB:
			return new MariaDBDAOFactory();
		case MSSQL :
			return new MSSqlDAOFactory();

		default:
			return null;
		}

	}
}
