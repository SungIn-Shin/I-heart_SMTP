package com.iheart.ssi.ies.dom;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.activation.DataSource;
import javax.mail.Address;

import org.apache.commons.mail.util.MimeMessageParser;

public class Email implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String memberId; 
	private String emailSubject;
	private String emailFrom;
	private String emailToAddress;
	private String emailCcAddress;
	private String emailBccAddress;
	private String emailAttachmentName;
	private String emailPlainContent;
	private String emailHtmlContent;
	private Date emailSentDate;
	
	public Email() {
	}
	
	//
	public Email(MimeMessageParser emailData){
		try {
			this.emailSubject = emailData.getSubject();
			this.emailFrom = emailData.getFrom();
			this.emailToAddress = addressListToString(emailData.getTo());
			this.emailCcAddress = addressListToString(emailData.getCc());
			this.emailBccAddress = addressListToString(emailData.getBcc());
			this.emailAttachmentName = attachmentListToString(emailData.getAttachmentList());
			this.emailPlainContent = emailData.getPlainContent();
			this.emailSentDate = emailData.getMimeMessage().getSentDate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public Date getEmailSentDate() {
		return emailSentDate;
	}

	public void setEmailSentDate(Date emailSentDate) {
		this.emailSentDate = emailSentDate;
	}

	@Override
	public String toString() {
		//
		StringBuilder sb = new StringBuilder();
		sb.append("Subject : ").append(emailSubject).append("\r\n");
		sb.append("From : ").append(emailFrom).append("\r\n");
		sb.append("To address : ").append(emailToAddress).append("\r\n");
		sb.append("cc address : ").append(emailCcAddress).append("\r\n");
		sb.append("Bcc address : ").append(emailBccAddress).append("\r\n");
		sb.append("attachment Name : ").append(emailAttachmentName).append("\r\n");
		sb.append("plain content : ").append(emailPlainContent).append("\r\n");
//		sb.append("Sent Date : ").append(emailSentDate).append("\r\n");
		sb.append("Sent Date : ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:sss").format(emailSentDate)).append("\r\n");
		return sb.toString();
	}

	private String attachmentListToString(List<DataSource> attList){
		
		StringBuffer sb = new StringBuffer();
		int listSize = attList.size();
		for(int i = 0; i < listSize; i++){
			if( i == listSize - 1){
				sb.append(attList.get(i).getName());
			} else{
				sb.append(attList.get(i).getName()).append(",");
			}
		}
		return sb.toString();
	}
	
	private String addressListToString(List<Address> addressList){
		StringBuffer sb = new StringBuffer();
		int listSize = addressList.size();
		
		for(int i = 0; i < listSize ; i++){
			if( i == listSize - 1){
				sb.append(addressList.get(i));
			} else{
				sb.append(addressList.get(i)).append(",");
			}
		}
		return sb.toString();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailToAddress() {
		return emailToAddress;
	}

	public void setEmailToAddress(String emailToAddress) {
		this.emailToAddress = emailToAddress;
	}

	public String getEmailCcAddress() {
		return emailCcAddress;
	}

	public void setEmailCcAddress(String emailCcAddress) {
		this.emailCcAddress = emailCcAddress;
	}

	public String getEmailBccAddress() {
		return emailBccAddress;
	}

	public void setEmailBccAddress(String emailBccAddress) {
		this.emailBccAddress = emailBccAddress;
	}

	public String getEmailAttachmentName() {
		return emailAttachmentName;
	}

	public void setEmailAttachmentName(String emailAttachmentName) {
		this.emailAttachmentName = emailAttachmentName;
	}

	public String getEmailPlainContent() {
		return emailPlainContent;
	}

	public void setEmailPlainContent(String emailPlainContent) {
		this.emailPlainContent = emailPlainContent;
	}

	public String getEmailHtmlContent() {
		return emailHtmlContent;
	}

	public void setEmailHtmlContent(String emailHtmlContent) {
		this.emailHtmlContent = emailHtmlContent;
	}
	
	
//	public Email(MimeMessageParser parser){
//		try {
//			sentDate =	parser.getMimeMessage().getSentDate();
//			size	=	parser.getMimeMessage().getSize();
//			subject	=	parser.getSubject();
//			from	=	parser.getFrom();
//			to		=	parser.getTo();
//			cc		=	parser.getCc();
//			bcc		=	parser.getBcc();
//			htmlContent = parser.getHtmlContent();
//			plainContent = parser.getPlainContent();
//			attachmentList = parser.getAttachmentList();
//			htmlContent = parser.getHtmlContent();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("SUBJECT : ").append(getSubject()).append("\r\n");
//		sb.append("FROM : ").append(getFrom()).append("\r\n");
//		
//		for(Address e : getTo()){
//			sb.append("TO : ").append(e).append("\r\n");
//		}
//		
//		for(Address e : getCc()){
//			sb.append("CC : ").append(e).append("\r\n");
//		}
//		
//		for(Address e : getBcc()){
//			sb.append("BCC : ").append(e).append("\r\n");
//		}
//		
//		for(DataSource e : getAttachmentList()){
//			sb.append("Attachement Name : ").append(e.getName()).append("\r\n");
//			sb.append("Attachement ContentType: ").append(e.getContentType()).append("\r\n");
//			sb.append("Attachement Content : ");
//			try {
//				InputStream content = e.getInputStream();
//				byte[] b = new byte[size];
//				content.read(b);
//				sb.append(new String(b)).append("\r\n");
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//		sb.append("================================================").append("\r\n");
//		sb.append("================================================").append("\r\n");
//		sb.append("================================================").append("\r\n");
//		return sb.toString();
//	}
}
