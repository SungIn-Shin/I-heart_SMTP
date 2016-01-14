package com.iheart.ssi.smtp.commons.gmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class ApacheCommonsEmail_Gmail {
	public static void main(String[] args) {
		try {
			// Email email = new SimpleEmail();
			// email.setHostName("smtp.googlemail.com");
			// email.setSmtpPort(465);
			// email.setAuthenticator(new DefaultAuthenticator("tlstjddls123",
			// "ajcylryaumqwvsze"));
			// email.setSSLOnConnect(true);
			// email.setFrom("tlstjddls123@gmail.com");
			// email.setSubject("TestMail");
			// email.setMsg("This is a test mail ... :-)");
			// email.addTo("tlstjddls123@naver.com");
			// email.send();

			// Create the attachment
			long start = System.currentTimeMillis();
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath("D:/currentLog.log");
			attachment.setPath("D:/B2B-Client.log");
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Picture of John");
			// attachment.setName("John");

			// Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("tlstjddls123", "ajcylryaumqwvsze"));
			email.setSSLOnConnect(true);
			email.addTo("tlstjddls123@naver.com", "John Doe");
			email.setFrom("tlstjddls123@gmail.com", "Me");
			email.setSubject("The picture");
			email.setMsg("Here is the picture you wanted");
			email.setDebug(true);
			// add the attachment
			email.attach(attachment);

			// send the email
			email.send();
			long end = System.currentTimeMillis();
			System.out.println((end - start) + "밀리세컨");
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
