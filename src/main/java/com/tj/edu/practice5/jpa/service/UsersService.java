package com.tj.edu.practice5.jpa.service;

import com.tj.edu.practice5.jpa.model.Users;
import com.tj.edu.practice5.jpa.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    public void put() {
        Users user = Users.builder()
                .name("이똘똘")
                .build();

        usersRepository.save(user);//세이브를 하지않으면 안되고 세이브를 하면나옴
    }

}
