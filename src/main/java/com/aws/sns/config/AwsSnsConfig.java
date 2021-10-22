package com.aws.sns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class AwsSnsConfig {

	@Primary
	@Bean
	public AmazonSNSClient getAmazonSnsClient() {
		return (AmazonSNSClient) AmazonSNSClientBuilder
				.standard()
				.withRegion(Regions.US_EAST_1)
				.withCredentials(
						new AWSStaticCredentialsProvider(
								new BasicAWSCredentials("AKIA3RC2MAD3LN374BSW"
									, "vU/pi6TfEDKW3JExhrjGib/+Mc8Vct1WZXWb5dXD"))
						)
				.build();
	}
	
}
