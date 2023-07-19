package com.tj.edu.practice5.jpa.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Getter
//@Setter
@ToString
@Entity
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = {AuditingEntityListener.class})
public class Publisher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books;
//    private Set<Book> books;

//    @ManyToOne
//    private List<Author> authors;
}
