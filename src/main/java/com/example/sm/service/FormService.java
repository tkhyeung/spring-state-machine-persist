package com.example.sm.service;

import com.example.sm.controller.request.FormCreateRequest;
import com.example.sm.controller.response.EventResponse;
import com.example.sm.model.Form;
import com.example.sm.repository.FormRepository;
import com.example.sm.state_machine.FormEvents;
import com.example.sm.state_machine.FormPersistHandlerConfig;
import com.example.sm.state_machine.FormPersistStateChangeListener;
import com.example.sm.state_machine.FormStates;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class FormService {

    @Autowired
    private FormRepository repository;

    @Autowired
    private PersistStateMachineHandler handler;

    public Form createForm(FormCreateRequest request){

        return repository.save(
                Form.builder()
                .content(request.getContent())
                .state(FormStates.INIT)
                .build()
        );
    }

    public EventResponse updateState(Long id, FormEvents event) {
        Form form = getForm(id);
        boolean result =   handler.handleEventWithState(
                MessageBuilder.withPayload(event.name()).setHeader(FormPersistStateChangeListener.FORM, form).build(),
                form.getState().name()
        );
        if(result) return new EventResponse("ACCEPTED");
        return new EventResponse("REJECTED");
    }

    public List<Form> getAllForms(){
        return repository.findAll();
    }

    public Form getForm(Long id){
        return repository.findById(id).orElse(new Form());
    }

}
