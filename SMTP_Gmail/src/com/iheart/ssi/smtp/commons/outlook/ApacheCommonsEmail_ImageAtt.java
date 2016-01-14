package com.iheart.ssi.smtp.commons.outlook;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

public class ApacheCommonsEmail_ImageAtt {
	public static void main(String[] args) {
		try {

			String htmlEmailTemplate = ".... <img src=\"http://www.apache.org/images/feather.gif\"> ....";
			URL url = new URL("http://www.apache.org");
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("HERA.i-heart.co.kr");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("sishin@i-heart.co.kr", "tjddlsdpdltm6*"));
			email.setFrom("sishin@i-heart.co.kr");
			email.setSubject("TestMail");
			email.setMsg("This is a test mail ... :-)"); // 여기서는 이놈이 안보일거임.
			email.addTo("tlstjddls123@naver.com");
			email.setDebug(true);
			
			// HTML Message 세팅
			email.setHtmlMsg(htmlEmailTemplate);
			// Client가 HTML Message를 지원하지 않으면 TextMsg를 띄워준다.
			email.setTextMsg("Your email client does not support HTML messages");
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
