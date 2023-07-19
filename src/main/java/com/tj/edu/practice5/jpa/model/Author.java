package com.tj.edu.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

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
public class Author extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    private List<Book> books;

//    @OneToMany
//    @JoinColumn
//    private List<AuthorAndBook> authorAndBookList;

//    @OneToMany
//    @JoinColumn
//    private List<Publisher> publisherList;
}
