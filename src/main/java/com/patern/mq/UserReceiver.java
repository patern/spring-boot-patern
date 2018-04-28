package com.patern.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.patern.entity.User;

@Component
public class UserReceiver {
	
	@RabbitListener(queues = "user")
	@RabbitHandler
	public void process(@Payload User user) {
		System.out.println("Receiver  : " + user.toString());
	}
}
