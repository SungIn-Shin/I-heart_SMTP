package com.iheart.ssi.ies.dom;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.activation.DataSource;
import javax.mail.Address;

import org.apache.commons.mail.util.MimeMessageParser;

public class Email implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String subject;
	private String from;
	private String plainContent;
	private String htmlContent;
	private List<Address> to;
	private List<Address> cc;
	private List<Address> bcc;
	private List<DataSource> attachmentList;
	
	int size;
	public Email() {
	}
	public Email(MimeMessageParser parser){
		try {
			size	=	parser.getMimeMessage().getSize();
			subject	=	parser.getSubject();
			from	=	parser.getFrom();
			to		=	parser.getTo();
			cc		=	parser.getCc();
			bcc		=	parser.getBcc();
			htmlContent = parser.getHtmlContent();
			plainContent = parser.getPlainContent();
			attachmentList = parser.getAttachmentList();
			htmlContent = parser.getHtmlContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public String getPlainContent() {
		return plainContent;
	}
	public void setPlainContent(String plainContent) {
		this.plainContent = plainContent;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<Address> getTo() {
		return to;
	}

	public void setTo(List<Address> to) {
		this.to = to;
	}

	public List<Address> getCc() {
		return cc;
	}

	public void setCc(List<Address> cc) {
		this.cc = cc;
	}

	public List<Address> getBcc() {
		return bcc;
	}

	public void setBcc(List<Address> bcc) {
		this.bcc = bcc;
	}

	public List<DataSource> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<DataSource> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SUBJECT : ").append(getSubject()).append("\r\n");
		sb.append("FROM : ").append(getFrom()).append("\r\n");
		
		for(Address e : getTo()){
			sb.append("TO : ").append(e).append("\r\n");
		}
		
		for(Address e : getCc()){
			sb.append("CC : ").append(e).append("\r\n");
		}
		
		for(Address e : getBcc()){
			sb.append("BCC : ").append(e).append("\r\n");
		}
		
		for(DataSource e : getAttachmentList()){
			sb.append("Attachement Name : ").append(e.getName()).append("\r\n");
			sb.append("Attachement ContentType: ").append(e.getContentType()).append("\r\n");
			sb.append("Attachement Content : ");
			try {
				InputStream content = e.getInputStream();
				byte[] b = new byte[size];
				content.read(b);
				sb.append(new String(b)).append("\r\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		sb.append("================================================").append("\r\n");
		sb.append("================================================").append("\r\n");
		sb.append("================================================").append("\r\n");
		return sb.toString();
	}
}
