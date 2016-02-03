package org.ssi.mime.parser;

import java.io.InputStream;
import java.util.List;

import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.util.MimeMessageParser;

public class MimeParser {
	//
	
	private InputStream is;
	
	

	
	public MimeParser(InputStream is){
		this.is = is;
		
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
			
			// 참조 뽑아내기
			List<Address> ccList = parser.getCc();
			
			for(Address e : ccList){
				System.out.println("CC : "+e);
			}
			
			//숨은 참조 뽑아내기
			List<Address> bccList = parser.getBcc();
			for(Address e : bccList){
				System.out.println("BCC : "+e);
			}
			
			
			
			//첨부파일 내용, 이름 
			List<DataSource> atta = parser.getAttachmentList();
			for(DataSource e : atta){
				System.out.println("첨부파일 명 : " + e.getName());
				System.out.println("첨부파일 컨텐츠 타입 : " + e.getContentType());
				InputStream is = e.getInputStream();
				byte[] b = new byte[8000];
				is.read(b);
				String s = new String(b, "UTF-8");
				System.out.println("본문 내용 : " + s);
			}
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
