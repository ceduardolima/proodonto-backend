package com.celc.proodonto.domain.controller;

import com.celc.proodonto.domain.user.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid UserDTO data) {
        System.out.println(data);
        return ResponseEntity.ok().build();
    }
}
