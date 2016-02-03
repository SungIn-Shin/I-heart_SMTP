package org.ssi.mime.parser;

import java.util.List;

/**
 *	@author SHINSHUNGIN
 *	https://ko.wikipedia.org/wiki/MIME#Content-Type 참고
 */
public class Mime {
	
	
	
	/**
	 * Mime Header Data
	 */
	private String received;
	private String date;
	private String from;
	private List<String> to;
	private List<String> cc;
	private String message;
	private String subject;
	
	/** ex)
	 *  MIME-Version: 1.0
	 */
	private String mimeVersion;
	
	/** ex)
	 *	Content-Type: multipart/mixed; boundary=frontier
	 *	이 헤더는 메세지의 타입과 서브타입을 나타낸다.
	 *	타입과 서브타입을 합쳐 MIME 타입이라 부른다.
	 */
	private String contentType;
	
	/**
	 *	ex)
	 *	Content-Type: multipart/mixed; boundary=frontier 
	 *	boundary는 메세지 파트를 구분하는 역할을 하며 메세지의 시작과 끝부분에도 나타난다.
	 */
	private String boundary;
	
	
	/**	ex)
	 *	Content-Transfer-Encoding: base64
	 *	MIME는 바이너리 데이터를 ASCII 텍스트 형식으로 변환하기 위한 몇가지 방법을 정의하고 있다.
	 *	1. 일반 SMTP에서 사용 가능한 인코딩
	 *		- 7bit
	 *		- quoted-printable
	 *		- base64
	 *	2. 8BITMIME에서 지원하는 SMTP 서버에서 사용가능한 인코딩
	 *		- 8bit
	 *		- binary
	 */
	private String contentTransferEncoding;
	
	/**
	 * ex) Content-Disposition: attachment; filename=log.conf
	 * 이 헤더는 첨부 파일의 이름을 표시하는 데 사용한다.
	 */
	private String contentDisposition;
	
	/**
	 * 이 헤더는 첨부파일의 설명ㅇ을 기술하는데 사용하는 것 같다...
	 */
	private String contentDescription;
	
	
	
	private String mimeBody;
	
	
	
	
	public String getMimeBody() {
		return mimeBody;
	}

	public void setMimeBody(String mimeBody) {
		this.mimeBody = mimeBody;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public String getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}

	public String getMimeVersion() {
		return mimeVersion;
	}

	public void setMimeVersion(String mimeVersion) {
		this.mimeVersion = mimeVersion;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getBoundary() {
		return boundary;
	}

	public void setBoundary(String boundary) {
		this.boundary = boundary;
	}

	public String getContentTransferEncoding() {
		return contentTransferEncoding;
	}

	public void setContentTransferEncoding(String contentTransferEncoding) {
		this.contentTransferEncoding = contentTransferEncoding;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
