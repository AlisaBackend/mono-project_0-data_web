package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service 
@RequiredArgsConstructor 
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto register(AuthRequest request) {
        if (userRepository.existsByName(request.getName())) {
            throw new RuntimeException("User already exists");
        }
        User user = User.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("ROLE_USER")
                .build();
        return toDto(userRepository.save(user));
    }
    
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public UserDto findByName(String name) {
        return userRepository.findByName(name)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found"));
        return toDto(user);
    }
    

    // public List<UserDto> getAll() {
    //     return userRepository.findAll()
    //     .stream()
    //     .map(this::toDto)
    //     .toList();
    // }

    // public UserDto getById(Long id) {
    //     User user = userRepository.findById(id)
    //     .orElseThrow(() -> new RuntimeException("User not found"));
    //     return toDto(user);
    // }

    // public UserDto create(UserDto dto) {
    //     User user = new User();
    //     user.setName(dto.getName());
    //     user.setEmail(dto.getEmail());
    //     return toDto(userRepository.save(user));
    // }

    // public UserDto update(Long id, UserDto dto) {
    //     User user = userRepository.findById(id)
    //     .orElseThrow(() -> new RuntimeException("User not found"));
    //     user.setName(dto.getName());
    //     user.setEmail(dto.getEmail());
    //     return toDto(userRepository.save(user));
    // }
    // public void delete(Long id) {
    //     userRepository.deleteById(id);
    // }

    // // Маппинг Entity -> DTO
    // private UserDto toDto(User user) {
    //     return new UserDto(user.getId(), user.getName(), user.getEmail()); 
    // }


}