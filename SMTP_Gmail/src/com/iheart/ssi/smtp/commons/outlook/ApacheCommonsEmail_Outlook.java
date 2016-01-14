package com.iheart.ssi.smtp.commons.outlook;

import java.awt.List;
import java.util.ArrayList;
import java.util.zip.ZipOutputStream;

import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class ApacheCommonsEmail_Outlook {
	public static void main(String[] args) {
		try {
			// Email email = new HtmlEmail();
			// email.setHostName("HERA.i-heart.co.kr");
			// email.setSmtpPort(587);
			// email.setAuthenticator(new
			// DefaultAuthenticator("sishin@i-heart.co.kr", "tjddlsdpdltm6*"));
			// email.setFrom("sishin@i-heart.co.kr");
			// email.setSubject("TestMail");
			// email.setMsg("This is a test mail ... :-)");
			// email.addTo("tlstjddls123@naver.com");
			// email.setDebug(true);
			// email.send();

			// Create the attachment
			// 첨부파일 전송.. EmailAttachment 객체 1개당 첨부파일 1개.
//			EmailAttachment attachment = new EmailAttachment();
//			attachment.setPath("D:/currentLog.log");
//			attachment.setDisposition(EmailAttachment.ATTACHMENT);
//			attachment.setDescription("Picture of John");
//			attachment.setName("John");
//
//			EmailAttachment attachment2 = new EmailAttachment();
//			attachment2.setPath("D:/log.conf");
//			attachment2.setDisposition(EmailAttachment.ATTACHMENT);
//			attachment2.setDescription("logFile");
//			attachment2.setName("LOG");

			String[] attArgs = { "D:/log.conf", "D:/currentLog.log" };
			
			// // Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("tlstjddls123", "ajcylryaumqwvsze"));
			email.setSSLOnConnect(true);
			email.addTo("tlstjddls123@naver.com", "John Doe");
			// 참조, 숨은 참조 
			email.addCc("tlstjddls1@naver.com");
			email.addBcc("sin5149@hanmail.net");
			// 참조, 숨은참조 Collection 형식
//			email.setCc(new ArrayList<InternetAddress>()); // Carbon Copy : 참조
//			email.setBcc(new ArrayList<InternetAddress>());// Bliend Carbon Copy : 숨은 참조
			email.setBounceAddress("tlstjddls123@naver.com"); //반송메일 주소 지정. 설정하지 않으면 기본 setFrom값으로 반송됨.
			email.setCharset("UTF-8"); // CharSet지정, 메세지 내용을 지정하기 전에 설정해야합니다.
			email.setFrom("tlstjddls123@gmail.com", "Me");
			email.setSubject("The picture");
			email.setMsg("Here is the picture you wanted");
			email.setDebug(true);
			setAttachments(attArgs, email); // 다중 첨부파일
			
			// send the email
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public static void setAttachments(String[] args, MultiPartEmail email) throws EmailException {
		//
		
		int attSize = args.length;
		for (int i = 0; i < attSize; i++) {
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(args[i]);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			//attachment.setName("파일 이름을 지정할 수 있음.");
			email.attach(attachment);
		}
	}
}
