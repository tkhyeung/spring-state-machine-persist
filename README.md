# spring-state-machine-persist

Demo project of 
* Spring State Machine
* Persist recipes to update state

State:
    
    INIT, SUBMITTED, REVIEWED, APPROVED
    
Event:
    
    SUBMIT, REVIEW, APPROVE

Flow:

    INIT --(SUBMIT)--> SUBMITTED --(REVIEW)--> REVIEWED --(APPROVE)--> APPROVED


Also demostrating same event can be used to have different state changes
    
    INIT --(APPROVE)--> APPROVED

Swagger:

http://localhost:8080/swagger-ui.html
