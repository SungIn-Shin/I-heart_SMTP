package com.iheart.ssi.dummy.agent;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class DummyAgentMain {
	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			String[] attArgs = { "D:/log.conf", "D:/currentLog.log" };
			
			// // Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("192.168.100.29");
			email.setSmtpPort(25000);
			email.setAuthenticator(null);
//			email.addTo("tlstjddls123@naver.com", "John Doe");
			email.addTo("tlstj@naver.com", "John Doe");
//			email.addTo("apple_hip@naver.com", "John Doe");
			// 참조, 숨은 참조 
			email.addCc("tlstjddls1@naver.com");
			email.addCc("apple_hip@naver.com");
			email.addBcc("sin5149@hanmail.net");
			// 참조, 숨은참조 Collection 형식
//			email.setCc(new ArrayList<InternetAddress>()); // Carbon Copy : 참조
//			email.setBcc(new ArrayList<InternetAddress>());// Bliend Carbon Copy : 숨은 참조
			email.setBounceAddress("tlstjddls123@naver.com"); //반송메일 주소 지정. 설정하지 않으면 기본 setFrom값으로 반송됨.
			email.setCharset("UTF-8"); // CharSet지정, 메세지 내용을 지정하기 전에 설정해야합니다.
			email.setFrom("tlstjddls123@gmail.com", "Me");
			email.setSubject("제목입니다.");
			email.setMsg("Here is the picture you wanted");
			email.setDebug(true);
			
			setAttachments(attArgs, email); // 다중 첨부파일
			
			// send the email
			String sendMsg = email.send();
			System.out.println("===============================");
			System.out.println(sendMsg);
			System.out.println("===============================");
			long end = System.currentTimeMillis();
			System.out.println((end - start) + "밀리세컨");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
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
