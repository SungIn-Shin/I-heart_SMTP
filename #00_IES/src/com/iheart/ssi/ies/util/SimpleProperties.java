package com.iheart.ssi.ies.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SimpleProperties extends Properties {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String path;
	public static SimpleProperties instance;
	
	private Properties properties;
	private SimpleProperties() {

	}

	private SimpleProperties(String path) {
		//
		System.out.println("SimpleProperties 객체 생성");
		this.path = path;
		try {
			InputStream is = new FileInputStream(path);
			super.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 
	 * @param 사용자지정properties 경로
	 * @return SimpleProperties 객체
	 */
	public static synchronized SimpleProperties getInstance(String path) {
		//
		if (instance == null) {
			
			instance = new SimpleProperties(path);
		} else {
			return instance;
		}
		return instance;
	}
	
	public static synchronized SimpleProperties getInstance() {
		//
		if (instance == null) {
			System.out.println("Class Path 에서 값을 찾습니다.");
		} else {
			return instance;
		}
		return instance;
	}
	
	public Properties getProperties() {
		return properties;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
