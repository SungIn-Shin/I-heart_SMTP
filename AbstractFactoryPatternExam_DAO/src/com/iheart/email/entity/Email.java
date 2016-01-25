package com.iheart.email.entity;

import java.io.Serializable;
import java.util.List;

public class Email implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	private String from;				// 보내는사람
	private List<String> to;			//받는사람(복수)
	private String bounceAddress;		//반송메일 본문
	private List<String> cc;			//참조(복수)
	private List<String> bcc;			//숨은 참조(복수)
	private String subject;				//메일 제목
	private String msg;					//메일 본문
	private List<String> attachments;	//첨부파일 이름들..
	
	
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public List<String> getTo() {
		return to;
	}
	public void setTo(List<String> to) {
		this.to = to;
	}
	public String getBounceAddress() {
		return bounceAddress;
	}
	public void setBounceAddress(String bounceAddress) {
		this.bounceAddress = bounceAddress;
	}
	public List<String> getCc() {
		return cc;
	}
	public void setCc(List<String> cc) {
		this.cc = cc;
	}
	public List<String> getBcc() {
		return bcc;
	}
	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<String> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}
	
	
	
}
