package com.iheart.ssi.ies.server;

import org.subethamail.smtp.auth.LoginFailedException;
import org.subethamail.smtp.auth.UsernamePasswordValidator;

import com.iheart.ssi.ies.dom.Member;
import com.iheart.ssi.ies.persister.MemberPersister;

public class IESUsernamePasswordValidator implements UsernamePasswordValidator {
	private MemberPersister memberPersister;
	public IESUsernamePasswordValidator() {
		//
		memberPersister = new MemberPersister();
	}
	@Override
	public void login(String username, String password) throws LoginFailedException {
		System.out.println("아이디 : " + username);
		System.out.println("비번 : " + password);
		/**
		 * DB에서 일치하는 값 체크.
		 * */
		int count = memberPersister.selectMember(new Member(username, password));
		
		if(count == 0){
			throw new LoginFailedException();
		}
		
	}
	
}
