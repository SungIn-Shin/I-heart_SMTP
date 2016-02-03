package org.ssi.mime.parser;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.util.MimeMessageParser;

public class MimeParser {
	//
	
	private InputStream is;
	
	private String mimeMessage;
	

	
	public MimeParser(InputStream is){
		this.is = is;
		
	}
	
	
	public MimeParser(String mimeMessage){
		this.mimeMessage = mimeMessage;
		
	}
	
	
	public List<Mime> parse(){
		try {
			MimeMessage emailMessage = new MimeMessage(null, is);
			MimeMessageParser parser = new MimeMessageParser(emailMessage);
			parser.parse();
			
			System.out.println("Mail Subject : " + parser.getSubject());
			System.out.println("Mail Plain Content : " + parser.hasPlainContent());
			System.out.println("Mail HTML Content : " + parser.hasHtmlContent());
			System.out.println("Mail Attachments : " + parser.hasAttachments());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
