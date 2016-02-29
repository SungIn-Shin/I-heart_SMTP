package com.iheart.ssi.ies.server;

import org.subethamail.smtp.auth.LoginAuthenticationHandlerFactory;
import org.subethamail.smtp.auth.UsernamePasswordValidator;
import org.subethamail.smtp.server.SMTPServer;

import com.iheart.ssi.ies.util.SimpleProperties;

public class IesServer {
	
	public static void main(String[] args) {
		
//		SimpleProperties props = SimpleProperties.getInstance(args[0]);
		@SuppressWarnings("unused")
		SimpleProperties props =SimpleProperties.getInstance("D:\\Git\\I-heart_SMTP\\#00_IES\\ies.properties");
		
		System.out.println("서버시작!!!");
		/**
		 * Email Data Handling Factory
		 **/
		IESMessageHandlerFactory iesFactory = new IESMessageHandlerFactory();
		
		UsernamePasswordValidator validator = new IESUsernamePasswordValidator();
		LoginAuthenticationHandlerFactory authFactory = new LoginAuthenticationHandlerFactory(validator);
		
		SMTPServer smtpServer = new SMTPServer(iesFactory, authFactory);
		smtpServer.setPort(25001);
		smtpServer.start();
	}
}
