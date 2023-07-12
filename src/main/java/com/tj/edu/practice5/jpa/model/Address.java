package com.tj.edu.practice5.jpa.model;


import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Address {
    @Id
    private Long id;
    private String zipcode;
}
