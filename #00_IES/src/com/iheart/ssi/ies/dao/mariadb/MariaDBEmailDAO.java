package com.iheart.ssi.ies.dao.mariadb;

import java.util.List;

import com.iheart.ssi.ies.dao.EmailDAO;
import com.iheart.ssi.ies.dom.Email;

public class MariaDBEmailDAO implements EmailDAO{
	
	
	
	@Override
	public int insertSentEmailHistory(Email email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Email> selectSentEmailHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Email> selectSentEmailHistory(String sender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Email> selectSentEmailHistory(String sender, String sentDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
