package com.iheart.ssi.ies.server;

import org.subethamail.smtp.MessageContext;
import org.subethamail.smtp.MessageHandler;
import org.subethamail.smtp.MessageHandlerFactory;

public class IESMessageHandlerFactory implements MessageHandlerFactory{

	@Override
	public MessageHandler create(MessageContext context) {
		// TODO Auto-generated method stub
		return new IESMessageHandler(context);
	}
}
