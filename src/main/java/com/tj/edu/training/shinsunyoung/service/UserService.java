package com.tj.edu.training.shinsunyoung.service;

import com.tj.edu.training.shinsunyoung.model.User;
import com.tj.edu.training.shinsunyoung.model.dto.AddUserRequest;
import com.tj.edu.training.shinsunyoung.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long register(AddUserRequest dto) {
        return userRepository.save(
                User.builder()
                        .email(dto.getEmail())
                        .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                        .build()).getId();
    }
}
