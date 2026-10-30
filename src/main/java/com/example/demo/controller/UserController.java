package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController 
@RequestMapping("/api/users")
@RequiredArgsConstructor 
public class UserController {

    private final UserService userService;

    @GetMapping 
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        // В UserService нужно добавить метод findById
        return ResponseEntity.ok(userService.findById(id)); 
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> me(Principal principal) {
        // Если principal == null, значит пользователь не авторизован
        if (principal == null) {
            return ResponseEntity.status(401).build(); // Возвращаем 401
        }
        return ResponseEntity.ok(userService.findByName(principal.getName()));
    }

    // @GetMapping("/{id}")
    // public UserDto getById(@PathVariable Long id) {
    //     return userService.getById(id);
    // }

    // @PostMapping 
    // public UserDto create(@RequestBody UserDto dto) {
    //     return userService.create(dto);
    // }

    // @PutMapping("/{id}")
    // public UserDto update(@PathVariable Long id, @RequestBody UserDto dto) {
    //     return userService.update(id, dto);
    // }

    // @DeleteMapping("/{id}")
    // public void delete(@PathVariable Long id) {
    //     userService.delete(id);
    // }
}