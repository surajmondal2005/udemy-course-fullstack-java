package com.eazybytes.eazystore.Controller;

import com.eazybytes.eazystore.scopes.RequestScopedBean;
import com.eazybytes.eazystore.scopes.SessionScopedBean;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/scope")
@RequiredArgsConstructor
public class ScopeController {
    private final RequestScopedBean requestScopedBean;
    private final SessionScopedBean sessionScopedBean;
    @GetMapping("/request")
    public ResponseEntity<String> testRequestScope(){
        requestScopedBean.setUserName("John Doe");
        return  ResponseEntity.ok().body(requestScopedBean.getUserName());
    }


    @GetMapping("/session")
    public ResponseEntity<String> testSessionScope(){
        sessionScopedBean.setUserName("John Doe");
        return  ResponseEntity.ok().body(sessionScopedBean.getUserName());
    }

    @GetMapping("/test1")
    public ResponseEntity<String> testScope2(){
        return  ResponseEntity.ok().body(sessionScopedBean.getUserName());
    }
}
