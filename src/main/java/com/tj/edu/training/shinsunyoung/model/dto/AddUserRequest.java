package com.tj.edu.training.shinsunyoung.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddUserRequest {
    private String email;
    private String password;
}
