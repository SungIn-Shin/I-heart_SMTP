package com.iheart.ssi.ies.util;

import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.util.MimeMessageParser;

import com.iheart.ssi.ies.dom.Email;

public class SMTPParser {
	
	public static Email parse(InputStream is){
		MimeMessage emailMessage = null;
		MimeMessageParser parser = null;
		try {
			emailMessage = new MimeMessage(null, is);
			parser = new MimeMessageParser(emailMessage);
			parser.parse();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Email(parser);
	}
}
