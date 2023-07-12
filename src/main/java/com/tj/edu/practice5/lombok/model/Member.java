package com.tj.edu.practice5.lombok.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
//@Entity
public class Member {
    //    @Id
    private Long id;
    private Integer age;
}
