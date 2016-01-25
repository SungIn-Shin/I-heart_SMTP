package com.iheart.email.client;

import com.iheart.email.dao.AbstractDAOFactory;
import com.iheart.email.dao.EmailDAO;

public class ExampleClient {
	public static void main(String[] args) {
		AbstractDAOFactory oracleFactory = AbstractDAOFactory.getDAOFactory("MySql");
		EmailDAO dao = oracleFactory.getEmailDAO();
		dao.insertEmail(null);
	}
}	
