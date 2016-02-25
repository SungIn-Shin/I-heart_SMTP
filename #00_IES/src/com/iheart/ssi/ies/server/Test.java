package com.iheart.ssi.ies.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("D:\\Git\\I-heart_SMTP\\#00_IES\\ies.properties");
			Properties props = new Properties();
			props.load(is);
			System.out.println(props.get("ORACLE.URL"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
