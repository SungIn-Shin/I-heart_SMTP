package com.iheart.email.dao;

import java.util.List;

import com.iheart.email.entity.Email;

public interface EmailDAO {
	//
	
	/**
	 * Email 전송 목록을 Insert 시킨다.
	 * @param emailList
	 * @return
	 */
	public int insertEmail(List<Email> emailList);
	
	/**
	 * Email전송 리스트를 모두 불러온다.
	 * @return
	 */
	public List<Email> selectAllEmailList();
	
	/**
	 * 발신자로 전송 리스트를 검색한다.
	 * @param senderName
	 * @return
	 */
	public List<Email> selectEmailList(String senderName);
	
}
