package com.iheart.ssi.builder;

import java.util.List;

public class Email {
	private String from;				// 보내는사람
	private List<String> to;			//받는사람(복수)
	private String bounceAddress;		//반송메일 본문
	private List<String> cc;			//참조(복수)
	private List<String> bcc;			//숨은 참조(복수)
	private String subject;				//메일 제목
	private String msg;					//메일 본문
	private List<String> attachments;	//첨부파일 이름들..
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public void setTo(List<String> to) {
		this.to = to;
	}
	
	public void setBounceAddress(String bounceAddress) {
		this.bounceAddress = bounceAddress;
	}
	
	public void setCc(List<String> cc) {
		this.cc = cc;
	}
	
	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}
	
	
}
