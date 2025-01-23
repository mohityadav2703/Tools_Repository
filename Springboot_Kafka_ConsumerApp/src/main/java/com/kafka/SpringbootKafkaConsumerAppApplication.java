package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.kafka.constants.AppConstants;


@SpringBootApplication
public class SpringbootKafkaConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaConsumerAppApplication.class, args);
	}
	
	@KafkaListener(topics = AppConstants.TOPIC, groupId="group_mohit_order")
	public void subscribeMsg(String order) {
		System.out.print("*** Msg Recieved From Kafka *** :: ");
		System.out.println(order);
		//logic
	}


}
