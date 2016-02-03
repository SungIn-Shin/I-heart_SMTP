package com.iheart.email.client;

import com.iheart.email.dao.AbstractDAOFactory;
import com.iheart.email.dao.EmailDAO;

public class ExampleClient {
	public static void main(String[] args) {
		AbstractDAOFactory oracleFactory = AbstractDAOFactory.getDAOFactory("oracle");
		EmailDAO dao = oracleFactory.getEmailDAO();
		
		AbstractDAOFactory mySqlFactory = AbstractDAOFactory.getDAOFactory("MySql");
		EmailDAO mySqlDAO = mySqlFactory.getEmailDAO();
		
		dao.insertEmail(null);
		mySqlDAO.insertEmail(null);
	}
}	
