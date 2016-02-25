package com.iheart.ssi.ies.dao;

import com.iheart.ssi.ies.dom.Member;

public class TestMain {
	public static void main(String[] args) {
		AbstractDAOFactory factory = AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.MARIADB);
		MemberDAO member = factory.getMemberDAO();
		System.out.println(member.selectMember(new Member("1111", "1111")));
	}
}
