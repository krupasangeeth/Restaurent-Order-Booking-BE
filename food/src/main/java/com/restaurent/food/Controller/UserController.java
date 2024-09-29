package com.restaurent.food.Controller;

import com.restaurent.food.DTO.UserDto;
import com.restaurent.food.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<UserDto> login(@RequestBody long mobile) {

        UserDto userDto = userService.login(mobile);

        return ResponseEntity.ok(userDto);
    }
}
