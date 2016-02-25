package com.iheart.ssi.ies.persister;

import java.util.Properties;

import com.iheart.ssi.ies.dao.AbstractDAOFactory;
import com.iheart.ssi.ies.dao.MemberDAO;
import com.iheart.ssi.ies.dom.Member;
import com.iheart.ssi.ies.util.SimpleProperties;

public class MemberPersister implements MemberDAO {
	private AbstractDAOFactory factory ;
	private MemberDAO dao;
	private Properties props = SimpleProperties.getInstance();
	
	public MemberPersister(){
		factory = AbstractDAOFactory.getDAOFactory(props.getProperty("DB.NAME"));
		dao = factory.getMemberDAO();
	}
	@Override
	public int selectMember(Member member) {
		//
		System.out.println("MemberPersister 호출");
		int count = dao.selectMember(member);
		return count;
	}

}
