package com.eazybytes.eazystore.Controller;
import com.eazybytes.eazystore.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dummy")
public class DummyController {
    @PostMapping("/create-user")
    public String createUser(@RequestBody UserDto userDto){
        System.out.println(userDto);
        return "User created successfully";

    }
}
