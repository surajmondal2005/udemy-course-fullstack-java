package com.eazybytes.eazystore.Controller;
import com.eazybytes.eazystore.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/dummy")
public class DummyController {
    @PostMapping("/create-user")
    public String createUser(@RequestBody UserDto userDto){
        System.out.println(userDto);
        return "User created successfully";

    }
    @GetMapping("/search")
    public String searchUser(@RequestParam(required = false,defaultValue = "Suraj" , name = "name") String userName){
        return "Hello hi " + userName;


    }
    @GetMapping("/multiple-search")
    public String searchUser(@RequestParam Map<String,String>params){
        return params.get("FirstName") + params.get("LastName");


    }

    @GetMapping({"/user/{userId}/posts/{postId}", "/user/{userId}"})
    public String getUser(@PathVariable(name = "userId") String id,
                          @PathVariable(required = false) String postId) {
        return "Searching for user : " + id + " and post : " + postId;
    }

    @GetMapping({"/user/map/{userId}/posts/{postId}", "/user/map/{userId}"})
    public String getUserUsingMap(@PathVariable Map<String,String> pathVariables) {
        return "Searching for user : " + pathVariables.get("userId") + " and post : "
                + pathVariables.get("postId");
    }

}

