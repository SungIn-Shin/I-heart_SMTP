package com.iheart.ssi.ies.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author SHINSHUNGIN
 * DB Agent로 부터 수신받은 Email Data를 DB에 처리 한 후 
 * 처리한 데이터 결과값을 Agent에게 응답 메세지를 전송합니다.
 */
public class IESResponseMessageSender extends Thread {
	
	private static Logger log = LoggerFactory.getLogger(IESResponseMessageSender.class);
	private String address;
	
	public IESResponseMessageSender(String address) {
		//
		System.out.println("SocketAddress : " + address);
		this.address = address;
		log.debug(address.toString());
	}
	
	
	@Override
	public void run() {
		try {
			Socket socket = new Socket(address.toString(), 9999);
			OutputStream output = socket.getOutputStream();
			output.write("hello".getBytes());
			output.flush();
			output.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
