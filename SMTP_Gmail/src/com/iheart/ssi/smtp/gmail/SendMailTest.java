package com.iheart.ssi.smtp.gmail;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * @author SHINSHUNGIN
 * Daum과 Gmail은 2차 인증 번호가 필요함. 비밀번호 -> 2차 인증번호
 */
public class SendMailTest {

	public static void main(String[] args) {
		List<String> toMail = new ArrayList<>();
		toMail.add("tlstjddls123@naver.com");
		String fromMail = "tlstjddls123@gmail.com";
		try {
			long start = System.currentTimeMillis();
			SendMailTest.send(toMail, fromMail, "hello SMTP test", "Title Test", "", "tlstjddls123",
					"ajcylryaumqwvsze"); // pwd = 2단계 인증번호임.
			long end = System.currentTimeMillis();
			System.out.println((end - start) + "밀리세컨");
		} catch (Exception e) {
			//
			e.printStackTrace();
		}
	}

	public static void send(List<String> toMail, String fromMail, String message, String title, String gmail, String id,
			String pwd) throws Exception {

		Properties p = new Properties();
		p.put("mail.smtp.user", "tlstjddls123@gmail.com");
		p.put("mail.smtp.host", "192.168.100.29");
		p.put("mail.smtp.port", "25000");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		Authenticator auth = new SMTPAuthenticator(id, pwd);
		Session session = Session.getInstance(p, auth);
		session.setDebug(true); // 메일을 전송할 때 상세한 상황을 콘솔에 출력한다.

		MimeMessage msg = new MimeMessage(session);

		msg.setSubject(title, "UTF-8");

		Address fromAddr = new InternetAddress(fromMail); // 보내는 사람의 메일주소

		msg.setFrom(fromAddr);

		InternetAddress[] addressTo = new InternetAddress[toMail.size()];

		for (int i = 0; i < toMail.size(); i++) {

			addressTo[i] = new InternetAddress(toMail.get(i));

		}

		msg.setRecipients(Message.RecipientType.TO, addressTo);

		msg.setContent(message, "text/html;charset=utf-8");

		Transport.send(msg);

	}

	private static class SMTPAuthenticator extends javax.mail.Authenticator {
		String id;
		String pwd;

		SMTPAuthenticator(String id, String pwd) {
			this.id = id;
			this.pwd = pwd;
		}
		public PasswordAuthentication getPasswordAuthentication() {
			// 구글아이디는 구글계정에서 @이후를제외한 값이다. (예:abcd@gmail.com -->abcd)
			return new PasswordAuthentication(id, pwd);
		}

	}
}
