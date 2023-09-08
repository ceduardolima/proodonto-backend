package com.celc.proodonto.domain.controller;

import com.celc.proodonto.domain.user.User;
import com.celc.proodonto.domain.user.UserDTO;
import com.celc.proodonto.domain.user.UserDetailDTO;
import com.celc.proodonto.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid UserDTO data, UriComponentsBuilder uriComponentsBuilder) {
        var user = new User(data);
        userRepository.save(user);
        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailDTO(user));
    }
}
