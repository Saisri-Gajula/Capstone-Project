package com.capstone.collectionprocesshandling.service;

import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class Twilioinitializer {
	
	private final Twilioproperties twilioproperties;
	
	public Twilioinitializer(Twilioproperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
		Twilio.init(twilioproperties.getAccountSid(), twilioproperties.getAuthToken());
	}

	public Object someMethod() {
		return null;
	}

}