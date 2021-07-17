package com.example.sm.state_machine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@EnableStateMachine
public class FormStateMachineConfig extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineStateConfigurer<String, String> state) throws Exception {
        state.withStates().initial(FormStates.INIT.name())
                .initial(FormStates.INIT.name())
//                .states(EnumSet.allOf(FormStates.class));
                .states(
                        EnumSet.allOf(FormStates.class).stream()
                        .map(FormStates::name).collect(Collectors.toSet())
                );
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
        transitions
                .withExternal()
                .source(FormStates.INIT.name())
                .target(FormStates.SUBMITTED.name())
                .event(FormEvents.SUBMIT.name())
                .and()
                .withExternal()
                .source(FormStates.SUBMITTED.name())
                .target(FormStates.REVIEWED.name())
                .event(FormEvents.REVIEW.name())
                .and()
                .withExternal()
                .source(FormStates.REVIEWED.name())
                .target(FormStates.APPROVED.name())
                .event(FormEvents.APPROVE.name())
        ;

    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<String, String> config) throws Exception {
        config.withConfiguration()
                .autoStartup(false)
                .listener(new FormStateMachineListener())

        ;
    }

}
