package com.celc.proodonto.domain.controller;

import com.celc.proodonto.domain.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity register(@RequestBody @Valid UserData data, UriComponentsBuilder uriComponentsBuilder) {
        var user = new User(data);
        userRepository.save(user);
        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailData(user));
    }

    @GetMapping
    public ResponseEntity list(@PageableDefault(size = 10, sort = {"name"}) Pageable page)  {
        var userPage = userRepository.findAll(page).map(UserListData::new);
        return ResponseEntity.ok(userPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var user = userRepository.getReferenceById(id);
        return ResponseEntity.ok(new UserDetailData(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var user = userRepository.getReferenceById(id);
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UserUpdateData userUpdateData) {
        var user = userRepository.getReferenceById(userUpdateData.id());
        user.update(userUpdateData);
        return ResponseEntity.ok(new UserDetailData(user));
    }
}
