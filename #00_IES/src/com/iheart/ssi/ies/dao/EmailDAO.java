package com.iheart.ssi.ies.dao;

import java.util.List;

import com.iheart.ssi.ies.dom.Email;

public interface EmailDAO {
	
	/** 이메일 전송 목록에 등록한다.
	 * @param email
	 * @return
	 */
	public int insertSentEmailHistory(Email email);
	
	/** 모든 전송 목록을 불러온다
	 * @return
	 */
	public List<Email> selectSentEmailHistory();
	
	/** 보낸사람이 일치하는 전송 목록을 불러온다.
	 * @param sender
	 * @return
	 */
	public List<Email> selectSentEmailHistory(String sender);
	
	
	/** 보낸사람과 전송일자가 일치하는 메일 전송 목록을 불러온다.
	 * @param sender
	 * @param sentDate
	 * @return
	 */
	public List<Email> selectSentEmailHistory(String sender, String sentDate);
}
