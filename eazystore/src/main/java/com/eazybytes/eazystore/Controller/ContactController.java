package com.eazybytes.eazystore.Controller;

import com.eazybytes.eazystore.dto.ContactRequestDto;
import com.eazybytes.eazystore.dto.ProductDto;
import com.eazybytes.eazystore.service.IContactService;
import com.eazybytes.eazystore.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final IContactService iContactService;
    @PostMapping
    public ResponseEntity<String> saveContact(@RequestBody ContactRequestDto contactRequestDto){
        boolean isSaved = iContactService.saveContact(contactRequestDto);
        if(isSaved){
            return ResponseEntity.status(HttpStatus.CREATED).body("Request processed successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.Please try again or contact dev team");
        }

    }

}
