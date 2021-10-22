package com.aws.sns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
public class AwsSnsController {

	@Autowired
	private AmazonSNSClient amazonSNSClient;

	private final String topicArn = "arn:aws:sns:us-east-1:792610996470:my-sns-topic";

	@GetMapping("/subscribe/{email}")
	public String subscribeToSnsTopic(@PathVariable String email) {
		SubscribeRequest subscribeRequest = 
				new SubscribeRequest(topicArn, "email", email);
		amazonSNSClient.subscribe(subscribeRequest);
		return "Kindly check you email";
	}
	
	@GetMapping("/publish/{msg}")
	public String publishToTopic(@PathVariable("msg") String msg) {
		PublishRequest publishRequest =
				new PublishRequest(topicArn, msg, "AWS SNS");
		amazonSNSClient.publish(publishRequest);
		return "Your message is published successfully !!!";
	}
}
