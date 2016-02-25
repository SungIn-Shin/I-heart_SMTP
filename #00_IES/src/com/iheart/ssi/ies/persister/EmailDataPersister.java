package com.iheart.ssi.ies.persister;

import java.util.List;
import java.util.Properties;

import com.iheart.ssi.ies.dao.AbstractDAOFactory;
import com.iheart.ssi.ies.dao.EmailDAO;
import com.iheart.ssi.ies.dom.Email;
import com.iheart.ssi.ies.util.SimpleProperties;

public class EmailDataPersister implements EmailDAO {
	
	private EmailDAO dao;
	
	private Properties props = SimpleProperties.getInstance();
	
	public EmailDataPersister() {
		//
		System.out.println("[EmailDataPersister] 연결할 DB Name : " + props.getProperty("DB.NAME"));
		AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory(props.getProperty("DB.NAME"));
		dao = factory.getEmailDAO();
	}
	
	
	@Override
	public int insertSentEmailHistory(Email email) {
		dao.insertSentEmailHistory(email);
		return 0;
	}

	@Override
	public List<Email> selectSentEmailHistory() {
		return null;
	}

	@Override
	public List<Email> selectSentEmailHistory(String sender) {
		return null;
	}

	@Override
	public List<Email> selectSentEmailHistory(String sender, String sentDate) {
		return null;
	}
	
}
