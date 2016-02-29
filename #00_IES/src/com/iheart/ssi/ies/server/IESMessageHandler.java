package com.iheart.ssi.ies.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.mail.util.MimeMessageParser;
import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.MessageHandler;
import org.subethamail.smtp.RejectException;
import org.subethamail.smtp.TooMuchDataException;

import com.iheart.ssi.ies.dom.Email;
import com.iheart.ssi.ies.util.SMTPParser;
import com.iheart.ssi.ies.util.SimpleProperties;

public class IESMessageHandler implements MessageHandler {
	MessageContext context;
	Properties props = SimpleProperties.getInstance();
	
	public IESMessageHandler(MessageContext context) {
		this.context = context;
		
	}


	@Override
	public void data(InputStream data) throws RejectException, TooMuchDataException, IOException {
		/**
		 * 1. 요청 받은 Email Data를 파싱한다.
		 * **/
		MimeMessageParser parser = SMTPParser.parse(data);
		/**
		 * 2. 파싱한 데이터를 Email객체에 담는다.
		 * */
		Email email = new Email(parser);
		System.out.println(email.toString());
		
		
//		EmailDAO dao = new EmailDataPersister();
//		int insertResultCount = dao.insertSentEmailHistory(emailData);
//		System.out.println("전송기록 등록 결과 값 : " + insertResultCount);
		
		/**
		 * 3. 저장 결과 값을 클라이언트에게 전송해준다. Thread 처리
		 */
		
		/**
		 * 4. Email Data를 I-Heart Exchange Server로 전송한다. (응답을 받을 수 없다.)
		 */
		
//		SqlSession session = sessionFactory.openSession();
//		session.insert("");
//		
//		String IPAddress = extractIPAddress();
//		IESResponseMessageSender sender = new IESResponseMessageSender(IPAddress);
//		sender.start();
	}

	@Override
	public void from(String from) throws RejectException {
		System.out.println("FROM:" + from);
	}

	@Override
	public void recipient(String recipient) throws RejectException {
		System.out.println("RECIPIENT:" + recipient);
	}

	@Override
	public void done() {
		System.out.println("Finished");
	}
	

	@SuppressWarnings("unused")
	private String extractIPAddress() {
		// SUNGIN/192.168.100.29:1923
		// 형식...
		String[] sp = context.getRemoteAddress().toString().split("/");
		String[] sp_1 =sp[1].split(":");
		String IPAddress = sp_1[0];
		return IPAddress;
	}
	
	
	public String convertStreamToString(InputStream is) {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
}
