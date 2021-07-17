package com.example.sm.state_machine;

import com.example.sm.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;

@Configuration
public class FormPersistHandlerConfig {

    @Autowired
    private StateMachine<String, String> entityStateMachine;

    @Autowired
    private FormRepository repository;

    @Bean
    public PersistStateMachineHandler persistStateMachineHandler() {
        PersistStateMachineHandler handler = new PersistStateMachineHandler(entityStateMachine);
        handler.addPersistStateChangeListener(new FormPersistStateChangeListener(repository));
        return handler;
    }
}
