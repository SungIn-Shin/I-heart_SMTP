package com.iheart.ssi.ies.dao.mariadb;

import com.iheart.ssi.ies.dao.AbstractDAOFactory;
import com.iheart.ssi.ies.dao.EmailDAO;
import com.iheart.ssi.ies.dao.MemberDAO;
import com.iheart.ssi.ies.dao.MonitoringDAO;

public class MariaDBDAOFactory extends AbstractDAOFactory {

	@Override
	public EmailDAO getEmailDAO() {
		// TODO Auto-generated method stub
		return new MariaDBEmailDAO();
	}

	@Override
	public MemberDAO getMemberDAO() {
		// TODO Auto-generated method stub
		return new MariaDBMemberDAO();
	}

	@Override
	public MonitoringDAO getMonitoringDAO() {
		// TODO Auto-generated method stub
		return new MariaDBMonitoringDAO();
	}

}
