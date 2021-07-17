package com.example.sm.state_machine;

import com.example.sm.model.Form;
import com.example.sm.repository.FormRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

@Slf4j
@AllArgsConstructor
public class FormPersistStateChangeListener implements PersistStateMachineHandler.PersistStateChangeListener {

    private FormRepository repository;

    public static final String FORM =  "FORM";
    @Override
    public void onPersist(State<String, String> state,
                          Message<String> message,
                          Transition<String, String> transition,
                          StateMachine<String, String> stateMachine) {
        log.info("state:{}, message:{}, transition:{},StateMachine:{}", state, message, transition, stateMachine);
        if (message != null && message.getHeaders().containsKey(FORM)) {
            Form form = message.getHeaders().get(FORM, Form.class);
            form.setState(FormStates.valueOf(state.getId()));
            repository.save(form);
        }
    }

}
