package com.iheart.ssi.ies.dao.mssql;

import java.sql.Connection;

import com.iheart.ssi.ies.dao.AbstractDAOFactory;
import com.iheart.ssi.ies.dao.EmailDAO;
import com.iheart.ssi.ies.dao.MemberDAO;
import com.iheart.ssi.ies.dao.MonitoringDAO;
import com.iheart.ssi.ies.dao.oracle.OracleEmailDAO;

public class MSSqlDAOFactory extends AbstractDAOFactory {
	public static final String DRIVER = "COM.cloudscape.core.RmiJdbcDriver";
	public static final String DBURL = "jdbc:cloudscape:rmi://localhost:1099/CoreJ2EEDB";

	public static Connection createConnection() {
		// Use DRIVER and DBURL to create a connection
		// Recommend connection pool implementation/usage
		return null;
	}

	@Override
	public EmailDAO getEmailDAO() {
		return new OracleEmailDAO();
	}

	@Override
	public MemberDAO getMemberDAO() {
		return null;
	}

	@Override
	public MonitoringDAO getMonitoringDAO() {
		return null;
	}

}
