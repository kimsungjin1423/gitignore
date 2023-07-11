package com.tj.edu.practice5.lombok.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
//@EqualsAndHashCode
public class User {
    @NonNull
    private String name;
    @NonNull
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
