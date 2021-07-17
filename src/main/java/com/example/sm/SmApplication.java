package com.example.sm;

import com.example.sm.state_machine.FormEvents;
import com.example.sm.state_machine.FormStates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import reactor.core.publisher.Mono;

/**
 * Spring State Machine code sample
 * Workflow using Spring State Machine
 */
@SpringBootApplication
@Slf4j
public class SmApplication implements CommandLineRunner {

//	@Autowired
//	private StateMachine<FormStates, FormEvents> stateMachine;

	public static void main(String[] args) {
		SpringApplication.run(SmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		log.info("*****State machine started*****");
//		stateMachine.startReactively().block();
//		log.info("*****State machine send APPROVE*****");
//		stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(FormEvents.APPROVE).build())).blockLast();
//		log.info("*****State machine send SUBMIT*****");
//		stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(FormEvents.SUBMIT).build())).blockLast();
//		log.info("*****State machine send REVIEW*****");
//		stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(FormEvents.REVIEW).build())).blockLast();
//		log.info("*****State machine send APPROVE*****");
//		stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(FormEvents.APPROVE).build())).blockLast();
//		stateMachine.stopReactively().block();
//		log.info("*****State machine ended*****");

	}
}
