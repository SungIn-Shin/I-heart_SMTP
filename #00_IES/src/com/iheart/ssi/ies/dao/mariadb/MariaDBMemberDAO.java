package com.iheart.ssi.ies.dao.mariadb;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.iheart.ssi.ies.dao.MemberDAO;
import com.iheart.ssi.ies.dom.Member;
import com.iheart.ssi.ies.util.SimpleProperties;

public class MariaDBMemberDAO implements MemberDAO{
	private SqlSessionFactory factory;
	Properties props = SimpleProperties.getInstance("D:\\Git\\I-heart_SMTP\\#00_IES\\ies.properties");
	public MariaDBMemberDAO() {
		//
		try {
			String resource = "com/iheart/ssi/ies/mybatis/config/mybatis-config.xml";
			String environment = props.getProperty("DB.NAME");
			Reader reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader, environment, props);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int selectMember(Member member) {
		//
		int result = 0;
		SqlSession session = null;
		try {
			session = factory.openSession();
			result = session.selectOne("com.iheart.ssi.ies.mybatis.mapper.MemberMapper.selectMember", member);
			System.out.println("멤버 유무 : " + result);
		} finally{
			session.close();
		}
		return result;
	}
	
}
