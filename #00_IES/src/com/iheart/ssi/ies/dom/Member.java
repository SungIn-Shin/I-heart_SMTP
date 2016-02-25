package com.iheart.ssi.ies.dom;

import java.io.Serializable;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String memberName;
	private String memberPwd;

	public Member(String memberName, String memberPwd) {
		super();
		this.memberName = memberName;
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

}
