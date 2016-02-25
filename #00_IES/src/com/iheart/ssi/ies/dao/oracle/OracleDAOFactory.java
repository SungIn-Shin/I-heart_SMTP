package com.iheart.ssi.ies.dao.oracle;

import com.iheart.ssi.ies.dao.AbstractDAOFactory;
import com.iheart.ssi.ies.dao.EmailDAO;
import com.iheart.ssi.ies.dao.MemberDAO;
import com.iheart.ssi.ies.dao.MonitoringDAO;

public class OracleDAOFactory extends AbstractDAOFactory {

	@Override
	public EmailDAO getEmailDAO() {
		// TODO Auto-generated method stub
		return new OracleEmailDAO();
	}

	/* (non-Javadoc)
	 * @see com.iheart.ssi.ies.dao.AbstractDAOFactory#getMemberDAO()
	 * 사용하지 않음.
	 */
	@Override
	public MemberDAO getMemberDAO() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iheart.ssi.ies.dao.AbstractDAOFactory#getMonitoringDAO()
	 * 사용하지 않음.
	 */
	@Override
	public MonitoringDAO getMonitoringDAO() {
		return null;
	}

}
