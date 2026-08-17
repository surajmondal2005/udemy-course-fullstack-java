package com.eazybytes.eazystore.scopes;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@Getter
@Setter
@Slf4j
@SessionScope
public class SessionScopedBean {
    private String userName;
    public SessionScopedBean(){
        log.info("Request Scoped Bean initialized");
    }
}
