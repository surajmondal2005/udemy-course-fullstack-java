package com.eazybytes.eazystore.scopes;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@Getter
@Setter
@Slf4j
@RequestScope
public class RequestScopedBean {
    private String userName;
    public RequestScopedBean(){
        log.info("Request Scoped Bean initialized");
    }
}
