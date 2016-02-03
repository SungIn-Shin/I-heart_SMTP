package com.iheart.ssi.smtp.test;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class EmailRelayServerMain {
	public static void main(String[] args) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "192.168.100.29");
			props.put("mail.smtp.port", "25000");
			props.put("mail.smtp.auth", "false");

			Authenticator authenticator = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(null, null);
				}
			};
			// props.put("mail.smtp.auth", "true");
			// props.put("mail.smtp.starttls.enable", "false");
			System.out.println("2");
			Session session = Session.getInstance(props, authenticator);
			// Session session = Session.getDefaultInstance(props) ;
			System.out.println("2");

			InternetAddress fromAddress = new InternetAddress("jungws55@daum.net", "성인", "UTF-8");
			InternetAddress toAddress = new InternetAddress("jungws55@nate.com", "성인", "UTF-8");

			MimeMessage message = new MimeMessage(session);
			message.setFrom(fromAddress);
			message.addRecipient(Message.RecipientType.TO, toAddress);
			message.setSubject(MimeUtility.encodeText("제목", "UTF-8", "B"));
			
			message.setContent("내용", " text/html; charset=UTF-8");
			Transport.send(message);
			System.out.println("[{}] 메일 발송 성공 jungws55@nate.com");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
