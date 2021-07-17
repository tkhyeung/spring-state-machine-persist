package com.example.sm.state_machine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

@Slf4j
public class FormStateMachineListener extends StateMachineListenerAdapter<String, String> {

    @Override
    public void stateChanged(State<String, String> from, State<String, String> to) {
        if(from != null) {
            log.info("State changed from {} to {}", from.getId(), to.getId());
        }else {
            log.info("State changed from {} to {}", "null state", to.getId());
        }
    }

    @Override
    public void eventNotAccepted(Message<String> event) {
        log.info("Event not accepted: {}", event.getPayload());
    }

}
